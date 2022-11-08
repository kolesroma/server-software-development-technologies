package com.server.software.dev.kolesnyk.service.impl;

import com.server.software.dev.kolesnyk.dto.AccountingDto;
import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import com.server.software.dev.kolesnyk.exception.AccountingNotFound;
import com.server.software.dev.kolesnyk.repository.AccountingRepository;
import com.server.software.dev.kolesnyk.service.AccountingService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class AccountingServiceImpl implements AccountingService {
    private final AccountingRepository accountingRepository;

    public AccountingServiceImpl(AccountingRepository accountingRepository) {
        this.accountingRepository = accountingRepository;
    }

    @Override
    public AccountingEntity saveAccounting(Integer balance) {
        return accountingRepository.save(AccountingEntity.builder().balance(balance).build());
    }

    @Override
    public Optional<AccountingEntity> getAccounting(Integer id) {
        return accountingRepository.findById(id);
    }

    @Override
    public Collection<AccountingEntity> getAllAccounting(Integer page, Integer size) {
        return accountingRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Override
    @Transactional
    public void updateAccounting(AccountingDto accountingDto, Integer id) {
        AccountingEntity accounting = accountingRepository.findById(id)
                .orElseThrow(AccountingNotFound::new);
        accounting.setBalance(accountingDto.getBalance());
        accountingRepository.save(accounting);
    }

    @Override
    @Transactional
    public void deleteAccounting(Integer id) {
        if (!accountingRepository.existsById(id)) {
            throw new AccountingNotFound();
        }
        accountingRepository.deleteById(id);
    }
}
