package com.server.software.dev.kolesnyk.service.impl;

import com.server.software.dev.kolesnyk.dto.RecordDto;
import com.server.software.dev.kolesnyk.entity.RecordEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.repository.RecordRepository;
import com.server.software.dev.kolesnyk.service.CategoryService;
import com.server.software.dev.kolesnyk.service.RecordService;
import com.server.software.dev.kolesnyk.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public RecordServiceImpl(RecordRepository recordRepository, UserService userService, CategoryService categoryService) {
        this.recordRepository = recordRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    @Transactional
    public void createRecord(RecordDto recordDto) {
        RecordEntity record = RecordEntity.builder()
                .user(userService.getUser(recordDto.getUserId()).orElseThrow(EntityNotFound::new))
                .category(categoryService.getCategory(recordDto.getCategoryId()).orElseThrow(EntityNotFound::new))
                .createdAt(Optional.ofNullable(recordDto.getCreatedAt()).orElse(LocalDateTime.now()))
                .outgo(recordDto.getOutgo())
                .build();
        recordRepository.save(record);
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

    //    todo calculate user balance when changing and creating
    @Override
    @Transactional
    public void updateRecord(RecordDto recordDto, Integer id) {
        RecordEntity record = recordRepository.findById(id)
                .orElseThrow(EntityNotFound::new);
        record.setUser(userService.getUser(recordDto.getUserId()).orElseThrow(EntityNotFound::new));
        record.setCategory(categoryService.getCategory(recordDto.getCategoryId()).orElseThrow(EntityNotFound::new));
        record.setCreatedAt(Optional.ofNullable(recordDto.getCreatedAt()).orElse(LocalDateTime.now()));
        record.setOutgo(recordDto.getOutgo());
        recordRepository.save(record);
    }

    @Override
    @Transactional
    public void deleteRecord(Integer id) {
        if (!recordRepository.existsById(id)) {
            throw new EntityNotFound();
        }
        recordRepository.deleteById(id);
    }
}
