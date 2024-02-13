package com.ca.application.gateway;

import com.ca.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
