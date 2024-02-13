package com.ca.application.gateway;

import com.ca.core.domain.Transaction;
import com.ca.core.exception.TransferException;

public interface ValidateTransactionGateway {
    Boolean validate(Transaction transaction) throws TransferException;
}
