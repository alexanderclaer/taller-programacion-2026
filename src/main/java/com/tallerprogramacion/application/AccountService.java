package com.tallerprogramacion.application;

import com.tallerprogramacion.domain.Account;
import com.tallerprogramacion.infrastructure.AccountRepository;

import java.math.BigDecimal;

public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void deposit(String accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId);
        account.deposit(amount);
        accountRepository.save(account);
    }

    public void withdraw(String accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId);
        account.withdraw(amount);
        accountRepository.save(account);
    }

    public void transfer(String fromAccountId, String toAccountId, BigDecimal amount) {
        Account fromAccount = accountRepository.findById(fromAccountId);
        Account toAccount = accountRepository.findById(toAccountId);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}