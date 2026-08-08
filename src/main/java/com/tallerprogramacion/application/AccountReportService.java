package com.tallerprogramacion.application;

import com.tallerprogramacion.domain.Account;
import com.tallerprogramacion.infrastructure.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Second service depending on the generic Repository abstraction (DIP),
 * separate from AccountService, to report on account data.
 */
public class AccountReportService {

    private final Repository<Account, String> repository;

    public AccountReportService(Repository<Account, String> repository) {
        this.repository = repository;
    }

    public BigDecimal totalBalance() {
        List<Account> accounts = repository.findAll();
        BigDecimal total = BigDecimal.ZERO;
        for (Account account : accounts) {
            total = total.add(account.getBalance());
        }
        return total;
    }

    public int accountCount() {
        return repository.findAll().size();
    }
}