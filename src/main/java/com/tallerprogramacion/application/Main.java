package com.tallerprogramacion.application;

import com.tallerprogramacion.domain.Account;
import com.tallerprogramacion.domain.AmountValidator;
import com.tallerprogramacion.domain.AmountValidatorHelper;
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

        // Functional interface demonstration: AmountValidator
        System.out.println("\n--- Amount Validator Demonstrations ---");

        // Lambda 1: amount must be positive
        AmountValidator isPositive = amount -> amount.compareTo(BigDecimal.ZERO) > 0;

        // Lambda 2: amount must not exceed a maximum limit
        AmountValidator isWithinLimit = amount -> amount.compareTo(new BigDecimal("10000")) <= 0;

        // Lambda 3: amount must have at most 2 decimal places
        AmountValidator hasValidScale = amount -> amount.scale() <= 2;

        // Method reference: reuse an existing static method
        AmountValidator isNotNull = AmountValidatorHelper::isNotNull;

        BigDecimal testAmount = new BigDecimal("150.75");
        System.out.println("Is positive? " + isPositive.isValid(testAmount));
        System.out.println("Is within limit? " + isWithinLimit.isValid(testAmount));
        System.out.println("Has valid scale? " + hasValidScale.isValid(testAmount));
        System.out.println("Is not null? " + isNotNull.isValid(testAmount));

        // DIP demonstration: second service using the generic Repository
        AccountReportService reportService = new AccountReportService(repository);
        System.out.println("\n--- Account Report Service ---");
        System.out.println("Total accounts: " + reportService.accountCount());
        System.out.println("Total balance across all accounts: " + reportService.totalBalance());
    }
}