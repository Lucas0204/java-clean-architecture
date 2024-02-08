package com.ca.core.domain;

import com.ca.core.domain.enums.UserTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Wallet {
    private Long id;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(BigDecimal balance, User user) {
        this.balance = balance;
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

    public void transfer(BigDecimal value) throws Exception {
        if (this.user.getType().equals(UserTypeEnum.SHOPKEEPER)) {
            throw new Exception("");
        }

        if (this.balance.compareTo(value) < 0) {
            throw new Exception("");
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
}
