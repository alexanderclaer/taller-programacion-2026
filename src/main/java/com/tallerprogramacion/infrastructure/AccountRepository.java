package com.tallerprogramacion.infrastructure;

import com.tallerprogramacion.domain.Account;

public interface AccountRepository {

    Account findById(String accountId);

    void save(Account account);
}