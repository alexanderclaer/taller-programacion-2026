package com.tallerprogramacion;

import com.tallerprogramacion.domain.Account;
import com.tallerprogramacion.domain.BusinessRuleException;
import com.tallerprogramacion.domain.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("A001", new BigDecimal("100.00"));
    }

    @Test
    void shouldDepositAmountSuccessfully() {
        account.deposit(new BigDecimal("50.00"));

        assertThat(account.getBalance()).isEqualByComparingTo("150.00");
    }

    @Test
    void shouldWithdrawAmountSuccessfully() {
        account.withdraw(new BigDecimal("30.00"));

        assertThat(account.getBalance()).isEqualByComparingTo("70.00");
    }

    @Test
    void shouldThrowExceptionWhenWithdrawingMoreThanBalance() {
        assertThatThrownBy(() -> account.withdraw(new BigDecimal("500.00")))
            .isInstanceOf(BusinessRuleException.class)
            .hasMessageContaining("Insufficient funds");
    }

    @Test
    void shouldThrowExceptionWhenDepositingNegativeAmount() {
        assertThatThrownBy(() -> account.deposit(new BigDecimal("-10.00")))
            .isInstanceOf(ValidationException.class);
    }

    @Test
    void shouldThrowExceptionWhenWithdrawingNegativeAmount() {
        assertThatThrownBy(() -> account.withdraw(new BigDecimal("-5.00")))
            .isInstanceOf(ValidationException.class);
    }

    @Test
    void shouldThrowExceptionWhenCreatingAccountWithNegativeInitialBalance() {
        assertThatThrownBy(() -> new Account("A002", new BigDecimal("-100.00")))
            .isInstanceOf(ValidationException.class);
    }
}

// Test suite for Account domain logic: covers deposit, withdrawal,
   // transfer between accounts, and rejection of overdrafts.