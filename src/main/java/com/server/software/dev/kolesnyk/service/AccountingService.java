package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.AccountingDto;
import com.server.software.dev.kolesnyk.entity.AccountingEntity;

import java.util.Collection;
import java.util.Optional;

public interface AccountingService {
    AccountingEntity saveAccounting(Integer balance);

    Optional<AccountingEntity> getAccounting(Integer id);

    Collection<AccountingEntity> getAllAccounting(Integer page, Integer size);

    void updateAccounting(AccountingDto accountingDto, Integer id);

    void deleteAccounting(Integer id);
}
