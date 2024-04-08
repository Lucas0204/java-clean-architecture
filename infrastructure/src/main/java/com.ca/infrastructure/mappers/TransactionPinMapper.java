package com.ca.infrastructure.mappers;

import com.ca.core.domain.TransactionPin;
import com.ca.infrastructure.entity.TransactionPinEntity;

public class TransactionPinMapper {
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transactionPin) {
        return new TransactionPinEntity(
            transactionPin.getPin(),
            transactionPin.getAttempt(),
            transactionPin.getBlocked(),
            transactionPin.getCreatedAt(),
            transactionPin.getUpdatedAt()
        );
    }
}
