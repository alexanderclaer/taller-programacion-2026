package com.tallerprogramacion.domain;

import java.math.BigDecimal;

public class Account {

    private final String id;
    private BigDecimal balance;

    public Account(String id, BigDecimal initialBalance) {
        if (initialBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new ValidationException("Initial balance cannot be negative");
        }
        this.id = id;
        this.balance = initialBalance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Deposit amount must be positive");
        }
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Withdrawal amount must be positive");
        }
        if (amount.compareTo(this.balance) > 0) {
            throw new BusinessRuleException(
                "Insufficient funds in account " + id + ". Available: " + balance
            );
        }
        this.balance = this.balance.subtract(amount);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}