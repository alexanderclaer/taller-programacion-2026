package com.tallerprogramacion.infrastructure;

import com.tallerprogramacion.domain.Account;

public interface AccountRepository extends Repository<Account, String> {
    // Inherits findById, save, findAll, deleteById from Repository<Account, String>
}