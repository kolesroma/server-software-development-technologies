package com.server.software.dev.kolesnyk.service.impl;

import com.server.software.dev.kolesnyk.dto.RecordDto;
import com.server.software.dev.kolesnyk.dto.UserDto;
import com.server.software.dev.kolesnyk.entity.RecordEntity;
import com.server.software.dev.kolesnyk.entity.UserEntity;
import com.server.software.dev.kolesnyk.exception.CategoryNotFound;
import com.server.software.dev.kolesnyk.exception.RecordNotFound;
import com.server.software.dev.kolesnyk.exception.UserNotFound;
import com.server.software.dev.kolesnyk.repository.RecordRepository;
import com.server.software.dev.kolesnyk.service.CategoryService;
import com.server.software.dev.kolesnyk.service.RecordService;
import com.server.software.dev.kolesnyk.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final Validator validator;

    public RecordServiceImpl(RecordRepository recordRepository, UserService userService, CategoryService categoryService, Validator validator) {
        this.recordRepository = recordRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.validator = validator;
    }

    @Override
    @Transactional
    public void createRecord(RecordDto recordDto) {
        UserEntity user = userService.getUser(recordDto.getUserId())
                .orElseThrow(UserNotFound::new);
        RecordEntity record = RecordEntity.builder()
                .user(user)
                .category(categoryService.getCategory(recordDto.getCategoryId()).orElseThrow(CategoryNotFound::new))
                .createdAt(Optional.ofNullable(recordDto.getCreatedAt()).orElse(LocalDateTime.now()))
                .outgo(recordDto.getOutgo())
                .build();
        UserDto userDto = UserDto.builder()
                .name(user.getName())
                .balance(user.getAccounting().getBalance() - record.getOutgo())
                .build();
        if (validator.validate(userDto).size() > 0) {
            throw new ValidationException("cannot apply balance < 0 for user");
        }
        recordRepository.save(record);
        userService.updateUser(userDto, user.getId());
    }

    @Override
    public Optional<RecordEntity> getRecord(Integer id) {
        return recordRepository.findById(id);
    }

    @Override
    public Collection<RecordEntity> getAllRecords(Integer page, Integer size) {
        return recordRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Override
    @Transactional
    public void updateRecord(RecordDto recordDto, Integer id) {
        RecordEntity record = recordRepository.findById(id)
                .orElseThrow(RecordNotFound::new);
        UserEntity user = userService.getUser(recordDto.getUserId())
                .orElseThrow(UserNotFound::new);
        UserDto userDto = UserDto.builder()
                .name(user.getName())
                .balance(user.getAccounting().getBalance() + record.getOutgo() - recordDto.getOutgo())
                .build();
        record.setUser(user);
        record.setCategory(categoryService.getCategory(recordDto.getCategoryId()).orElseThrow(CategoryNotFound::new));
        record.setCreatedAt(Optional.ofNullable(recordDto.getCreatedAt()).orElse(LocalDateTime.now()));
        record.setOutgo(recordDto.getOutgo());
        if (validator.validate(userDto).size() > 0) {
            throw new ValidationException("cannot apply balance < 0 for user");
        }
        recordRepository.save(record);
        userService.updateUser(userDto, user.getId());
    }

    @Override
    @Transactional
    public void deleteRecord(Integer id) {
        if (!recordRepository.existsById(id)) {
            throw new RecordNotFound();
        }
        recordRepository.deleteById(id);
    }
}
