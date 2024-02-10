package com.ca.usecase;

import com.ca.core.domain.Transaction;

public interface ValidateTransactionUseCase {
    Boolean validate(Transaction transaction);
}
