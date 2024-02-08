package com.ca.core.domain;

import java.time.LocalDateTime;

public class TransactionPin {
    private Long id;
    private User user;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin(Long id, User user, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(User user, String pin, Integer attempt, Boolean blocked) {
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {
    }
}
