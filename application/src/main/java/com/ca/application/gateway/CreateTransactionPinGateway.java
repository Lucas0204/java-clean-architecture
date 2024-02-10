package com.ca.application.gateway;

import com.ca.core.domain.TransactionPin;

public interface CreateTransactionPinGateway {
    void create(TransactionPin transactionPin);
}
