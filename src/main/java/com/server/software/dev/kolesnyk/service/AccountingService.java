package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.AccountingDto;
import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.repository.AccountingRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class AccountingService {
    private final AccountingRepository accountingRepository;

    public AccountingService(AccountingRepository accountingRepository) {
        this.accountingRepository = accountingRepository;
    }

    public AccountingEntity saveAccounting(Integer balance) {
        return accountingRepository.save(AccountingEntity.builder().balance(balance).build());
    }

    public Optional<AccountingEntity> getAccounting(Integer id) {
        return accountingRepository.findById(id);
    }

    public Collection<AccountingEntity> getAllAccounting(Integer page, Integer size) {
        return accountingRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Transactional
    public void updateAccounting(AccountingDto accountingDto, Integer id) {
        AccountingEntity accounting = accountingRepository.findById(id)
                .orElseThrow(EntityNotFound::new);
        accounting.setBalance(accountingDto.getBalance());
        accountingRepository.save(accounting);
    }

    @Transactional
    public void deleteAccounting(Integer id) {
        if (!accountingRepository.existsById(id)) {
            throw new EntityNotFound();
        }
        accountingRepository.deleteById(id);
    }
}
