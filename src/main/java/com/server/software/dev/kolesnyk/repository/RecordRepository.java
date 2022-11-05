package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.RecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends CrudRepository<RecordEntity, Integer> {
}
