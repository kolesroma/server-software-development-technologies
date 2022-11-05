package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.repository.AccountingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountingService {
    private final AccountingRepository accountingRepository;

    public AccountingService(AccountingRepository accountingRepository) {
        this.accountingRepository = accountingRepository;
    }

    public AccountingEntity saveAccounting(Integer balance) {
        return accountingRepository.save(AccountingEntity.builder().balance(balance).build());
    }

    @Transactional
    public void deleteAccounting(Integer id) {
        if (!accountingRepository.existsById(id)) {
            throw new EntityNotFound();
        }
        accountingRepository.deleteById(id);
    }
}
