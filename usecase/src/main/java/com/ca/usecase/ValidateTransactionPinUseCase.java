package com.ca.usecase;

import com.ca.core.domain.TransactionPin;
import com.ca.core.exception.PinException;

public interface ValidateTransactionPinUseCase {
    Boolean validate(TransactionPin transactionPin) throws PinException;
}
