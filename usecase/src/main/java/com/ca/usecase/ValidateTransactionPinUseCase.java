package com.ca.usecase;

import com.ca.core.domain.TransactionPin;
import com.ca.core.exception.TransferException;

public interface ValidateTransactionPinUseCase {
    Boolean validate(TransactionPin transactionPin) throws TransferException;
}
