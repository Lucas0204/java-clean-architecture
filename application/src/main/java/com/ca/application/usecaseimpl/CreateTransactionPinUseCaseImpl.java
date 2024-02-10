package com.ca.application.usecaseimpl;

import com.ca.application.gateway.CreateTransactionPinGateway;
import com.ca.core.domain.TransactionPin;
import com.ca.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {
    private CreateTransactionPinGateway createTransactionPinGateway;
    @Override
    public void create(TransactionPin transactionPin) {
        createTransactionPinGateway.create(transactionPin);
    }
}
