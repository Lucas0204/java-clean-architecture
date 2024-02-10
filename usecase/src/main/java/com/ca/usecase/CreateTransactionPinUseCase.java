package com.ca.usecase;

import com.ca.core.domain.Transaction;
import com.ca.core.domain.TransactionPin;

public interface CreateTransactionPinUseCase {
    void create(TransactionPin transactionPin);
}
