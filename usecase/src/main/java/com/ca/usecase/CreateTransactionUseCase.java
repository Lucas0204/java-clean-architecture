package com.ca.usecase;

import com.ca.core.domain.Transaction;
import com.ca.core.exception.TransactionException;

public interface CreateTransactionUseCase {
    Transaction create(Transaction transaction) throws TransactionException;
}
