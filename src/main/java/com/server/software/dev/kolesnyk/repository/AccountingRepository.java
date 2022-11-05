package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends CrudRepository<AccountingEntity, Integer> {
}
