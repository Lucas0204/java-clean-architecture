package com.ca.application.gateway;

import com.ca.core.domain.Transaction;

public interface CreateTransactionGateway {
    Transaction create(Transaction transaction);
}
