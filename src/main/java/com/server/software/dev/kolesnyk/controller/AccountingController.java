package com.server.software.dev.kolesnyk.controller;


import com.server.software.dev.kolesnyk.dto.AccountingDto;
import com.server.software.dev.kolesnyk.entity.AccountingEntity;
import com.server.software.dev.kolesnyk.service.AccountingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/accounting")
public class AccountingController {
    private final AccountingService accountingService;

    public AccountingController(AccountingService accountingService) {
        this.accountingService = accountingService;
    }

    @GetMapping("/{accountingId}")
    public ResponseEntity<AccountingEntity> getAccountingById(@PathVariable Integer accountingId) {
        return ResponseEntity.of(accountingService.getAccounting(accountingId));
    }

    @GetMapping
    public Collection<AccountingEntity> getAllAccounting(@RequestParam Integer page, @RequestParam Integer size) {
        return accountingService.getAllAccounting(page, size);
    }

    @PatchMapping("/{accountingId}")
    public void updateAccounting(@RequestBody @Valid AccountingDto accounting, @PathVariable Integer accountingId) {
        accountingService.updateAccounting(accounting, accountingId);
    }

    @DeleteMapping("/{accountingId}")
    public void deleteAccounting(@PathVariable Integer accountingId) {
        accountingService.deleteAccounting(accountingId);
    }
}
