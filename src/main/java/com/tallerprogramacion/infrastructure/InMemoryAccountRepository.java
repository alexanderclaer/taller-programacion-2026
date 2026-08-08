package com.tallerprogramacion.infrastructure;

import com.tallerprogramacion.domain.Account;
import com.tallerprogramacion.domain.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {

    private final Map<String, Account> accounts = new HashMap<>();

    @Override
    public Account findById(String accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new EntityNotFoundException("Account", accountId);
        }
        return account;
    }

    @Override
    public void save(Account account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public void deleteById(String accountId) {
        accounts.remove(accountId);
    }
}