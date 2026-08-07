package com.tallerprogramacion.infrastructure;

import com.tallerprogramacion.domain.Account;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {

    private final Map<String, Account> accounts = new HashMap<>();

    @Override
    public Account findById(String accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account not found: " + accountId);
        }
        return account;
    }

    @Override
    public void save(Account account) {
        accounts.put(account.getId(), account);
    }
}