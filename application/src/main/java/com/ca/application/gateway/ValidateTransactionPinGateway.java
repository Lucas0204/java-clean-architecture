package com.ca.application.gateway;

import com.ca.core.domain.TransactionPin;
import com.ca.core.exception.TransferException;

public interface ValidateTransactionPinGateway {
    Boolean validate(TransactionPin transactionPin);
}
