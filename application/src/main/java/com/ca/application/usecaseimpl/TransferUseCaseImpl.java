package com.ca.application.usecaseimpl;

import com.ca.application.gateway.TransferGateway;
import com.ca.core.domain.Transaction;
import com.ca.core.domain.Wallet;
import com.ca.core.exception.NotFoundException;
import com.ca.core.exception.NotificationException;
import com.ca.core.exception.TransactionException;
import com.ca.core.exception.TransferException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.*;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {
    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;
    private final CreateTransactionUseCase createTransactionUseCase;
    private final ValidateTransactionUseCase validateTransactionUseCase;
    private final TransferGateway transferGateway;
    private final UserNotificationUseCase userNotificationUseCase;
    private final ValidateTransactionPinUseCase validateTransactionPinUseCase;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase,
                               CreateTransactionUseCase createTransactionUseCase,
                               ValidateTransactionUseCase validateTransactionUseCase,
                               TransferGateway transferGateway,
                               UserNotificationUseCase userNotificationUseCase,
                               ValidateTransactionPinUseCase validateTransactionPinUseCase) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.validateTransactionUseCase = validateTransactionUseCase;
        this.transferGateway = transferGateway;
        this.userNotificationUseCase = userNotificationUseCase;
        this.validateTransactionPinUseCase = validateTransactionPinUseCase;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws TransferException, NotFoundException, NotificationException, TransactionException {
        Wallet from = findWalletByTaxNumberUseCase.findWalletByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findWalletByTaxNumber(fromTaxNumber);

        if (from.getTransactionPin().getBlocked()) {
            throw new TransferException(ErrorCodeEnum.PIN0001.getMessage(), ErrorCodeEnum.PIN0001.getCode());
        }

        validateTransactionPinUseCase.validate(from.getTransactionPin());

        from.transfer(value);
        to.receiveValue(value);

        var transaction = createTransactionUseCase.create(new Transaction(from, to, value));

        if (!validateTransactionUseCase.validate(transaction)) {
            rollbackTransfer(from, to, value);
            throw new TransferException(ErrorCodeEnum.TR0003.getMessage(), ErrorCodeEnum.TR0003.getCode());
        }

        if (!transferGateway.transfer(transaction)) {
            rollbackTransfer(from, to, value);
            throw new TransferException(ErrorCodeEnum.TR0004.getMessage(), ErrorCodeEnum.TR0004.getCode());
        }

        if (!userNotificationUseCase.notificate(transaction, to.getUser().getEmail())) {
            throw new NotificationException(ErrorCodeEnum.NF0001.getMessage(), ErrorCodeEnum.NF0001.getCode());
        }

        return null;
    }

    private void rollbackTransfer(Wallet from, Wallet to, BigDecimal value) {
        from.receiveValue(value);
        try {
            to.transfer(value);
        } catch (TransferException e) {}
    }
}
