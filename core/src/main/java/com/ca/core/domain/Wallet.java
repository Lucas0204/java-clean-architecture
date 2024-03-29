package com.ca.core.domain;

import com.ca.core.domain.enums.UserTypeEnum;
import com.ca.core.exception.TransferException;
import com.ca.core.exception.enums.ErrorCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {
    private Long id;
    private BigDecimal balance;
    private TransactionPin transactionPin;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id, TransactionPin transactionPin, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.transactionPin = transactionPin;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(BigDecimal balance, TransactionPin transactionPin, User user) {
        this.balance = balance;
        this.transactionPin = transactionPin;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        this.balance.add(value);
    }

    public void transfer(BigDecimal value) throws TransferException {
        if (this.user.getType().equals(UserTypeEnum.SHOPKEEPER)) {
            throw new TransferException(ErrorCodeEnum.TR0001.getMessage(), ErrorCodeEnum.TR0001.getCode());
        }

        if (this.balance.compareTo(value) < 0) {
            throw new TransferException(ErrorCodeEnum.TR0002.getMessage(), ErrorCodeEnum.TR0002.getCode());
        }

        this.balance.subtract(value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wallet wallet)) return false;
        return Objects.equals(getId(), wallet.getId()) && Objects.equals(getBalance(), wallet.getBalance()) && Objects.equals(getTransactionPin(), wallet.getTransactionPin()) && Objects.equals(getUser(), wallet.getUser()) && Objects.equals(getCreatedAt(), wallet.getCreatedAt()) && Objects.equals(getUpdatedAt(), wallet.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance(), getTransactionPin(), getUser(), getCreatedAt(), getUpdatedAt());
    }
}
