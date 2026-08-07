package com.tallerprogramacion.application;

import com.tallerprogramacion.domain.Account;
import com.tallerprogramacion.infrastructure.AccountRepository;
import com.tallerprogramacion.infrastructure.InMemoryAccountRepository;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        AccountRepository repository = new InMemoryAccountRepository();
        AccountService service = new AccountService(repository);

        Account accountA = new Account("A001", new BigDecimal("100.00"));
        Account accountB = new Account("B001", new BigDecimal("50.00"));
        repository.save(accountA);
        repository.save(accountB);

        service.deposit("A001", new BigDecimal("25.00"));
        System.out.println("A001 balance after deposit: " + repository.findById("A001").getBalance());

        service.withdraw("A001", new BigDecimal("10.00"));
        System.out.println("A001 balance after withdrawal: " + repository.findById("A001").getBalance());

        service.transfer("A001", "B001", new BigDecimal("30.00"));
        System.out.println("A001 balance after transfer: " + repository.findById("A001").getBalance());
        System.out.println("B001 balance after transfer: " + repository.findById("B001").getBalance());
    }
}