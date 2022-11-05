package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.RecordDto;
import com.server.software.dev.kolesnyk.entity.RecordEntity;

import java.util.Collection;
import java.util.Optional;

public interface RecordService {
    void createRecord(RecordDto recordDto);

    Optional<RecordEntity> getRecord(Integer id);

    Collection<RecordEntity> getAllRecords(Integer page, Integer size);

    void updateRecord(RecordDto recordDto, Integer id);

    void deleteRecord(Integer id);
}
