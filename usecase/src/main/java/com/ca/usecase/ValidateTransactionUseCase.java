package com.ca.usecase;

import com.ca.core.domain.Transaction;
import com.ca.core.exception.TransferException;

public interface ValidateTransactionUseCase {
    Boolean validate(Transaction transaction) throws TransferException;
}
