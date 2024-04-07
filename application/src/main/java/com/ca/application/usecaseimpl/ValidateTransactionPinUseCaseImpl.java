package com.ca.application.usecaseimpl;

import com.ca.application.gateway.ValidateTransactionGateway;
import com.ca.application.gateway.ValidateTransactionPinGateway;
import com.ca.core.domain.TransactionPin;
import com.ca.core.exception.PinException;
import com.ca.core.exception.TransferException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.UpdateTransactionPinUseCase;
import com.ca.usecase.ValidateTransactionPinUseCase;

public class ValidateTransactionPinUseCaseImpl implements ValidateTransactionPinUseCase {
    private final ValidateTransactionPinGateway validateTransactionPinGateway;
    private final UpdateTransactionPinUseCase updateTransactionPinUseCase;

    public ValidateTransactionPinUseCaseImpl(
            ValidateTransactionPinGateway validateTransactionPinGateway,
            UpdateTransactionPinUseCase updateTransactionPinUseCase
    ) {
        this.validateTransactionPinGateway = validateTransactionPinGateway;
        this.updateTransactionPinUseCase = updateTransactionPinUseCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws PinException {
        if (transactionPin.getBlocked()) {
            throw new PinException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }

        if (!validateTransactionPinGateway.validate(transactionPin)) {
            transactionPin.setAttempt(transactionPin.getAttempt() - 1);
            var updatedTransactionPin = updateTransactionPinUseCase.update(transactionPin);
            throw new PinException(ErrorCodeEnum.pin0002GetMessage(updatedTransactionPin.getAttempt()), ErrorCodeEnum.PIN0002.getCode());
        }

        if (transactionPin.getAttempt() < 3) {
            transactionPin.resetAttempts();
            updateTransactionPinUseCase.update(transactionPin);
        }

        return Boolean.TRUE;
    }
}
