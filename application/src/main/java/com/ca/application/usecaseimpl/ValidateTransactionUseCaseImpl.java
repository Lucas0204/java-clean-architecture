package com.ca.application.usecaseimpl;

import com.ca.application.gateway.ValidateTransactionGateway;
import com.ca.core.domain.Transaction;
import com.ca.core.exception.TransferException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.ValidateTransactionUseCase;

public class ValidateTransactionUseCaseImpl implements ValidateTransactionUseCase {
    private final ValidateTransactionGateway validateTransactionGateway;

    public ValidateTransactionUseCaseImpl(ValidateTransactionGateway validateTransactionGateway) {
        this.validateTransactionGateway = validateTransactionGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if (!validateTransactionGateway.validate(transaction)) {
            throw new TransferException(ErrorCodeEnum.TR0005.getMessage(), ErrorCodeEnum.TR0005.getCode());
        }
        return Boolean.TRUE;
    }
}
