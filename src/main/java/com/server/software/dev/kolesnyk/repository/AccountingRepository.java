package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingRepository extends PagingAndSortingRepository<AccountingEntity, Integer> {
}
