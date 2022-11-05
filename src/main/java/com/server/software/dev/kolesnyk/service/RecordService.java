package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.RecordDto;
import com.server.software.dev.kolesnyk.entity.RecordEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.repository.RecordRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class RecordService {
    private final RecordRepository recordRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public RecordService(RecordRepository recordRepository, UserService userService, CategoryService categoryService) {
        this.recordRepository = recordRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

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

    public Optional<RecordEntity> getRecord(Integer id) {
        return recordRepository.findById(id);
    }

    public Collection<RecordEntity> getAllRecords(Integer page, Integer size) {
        return recordRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    //    todo calculate user balance when changing and creating
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

    @Transactional
    public void deleteRecord(Integer id) {
        if (!recordRepository.existsById(id)) {
            throw new EntityNotFound();
        }
        recordRepository.deleteById(id);
    }
}
