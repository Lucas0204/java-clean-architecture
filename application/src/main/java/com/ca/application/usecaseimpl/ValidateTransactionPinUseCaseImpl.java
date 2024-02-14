package com.ca.application.usecaseimpl;

import com.ca.application.gateway.ValidateTransactionGateway;
import com.ca.application.gateway.ValidateTransactionPinGateway;
import com.ca.core.domain.TransactionPin;
import com.ca.core.exception.TransferException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.ValidateTransactionPinUseCase;

public class ValidateTransactionPinUseCaseImpl implements ValidateTransactionPinUseCase {
    private final ValidateTransactionPinGateway validateTransactionPinGateway;

    public ValidateTransactionPinUseCaseImpl(ValidateTransactionPinGateway validateTransactionPinGateway) {
        this.validateTransactionPinGateway = validateTransactionPinGateway;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws TransferException {
        if (!validateTransactionPinGateway.validate(transactionPin)) {
            throw new TransferException(ErrorCodeEnum.TR0005.getMessage(), ErrorCodeEnum.TR0005.getCode());
        }
        return Boolean.TRUE;
    }
}
