package com.ca.usecase;

import com.ca.core.domain.Transaction;

public interface CreateTransactionUseCase {
    void create(Transaction transaction);
}
