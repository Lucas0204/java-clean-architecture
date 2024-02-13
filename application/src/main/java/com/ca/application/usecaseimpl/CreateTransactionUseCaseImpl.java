package com.ca.application.usecaseimpl;

import com.ca.application.gateway.CreateTransactionGateway;
import com.ca.core.domain.Transaction;
import com.ca.core.exception.TransactionException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.CreateTransactionUseCase;

import java.util.Objects;

public class CreateTransactionUseCaseImpl implements CreateTransactionUseCase {
    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionUseCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransactionException {
        Transaction savedTransaction = createTransactionGateway.create(transaction);
        if (Objects.isNull(savedTransaction)) {
            throw new TransactionException(ErrorCodeEnum.TR0006.getMessage(), ErrorCodeEnum.TR0006.getCode());
        }

        return savedTransaction;
    }
}
