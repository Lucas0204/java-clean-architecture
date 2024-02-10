package com.ca.application.usecaseimpl;

import com.ca.application.gateway.CreateUserGateway;
import com.ca.core.domain.TransactionPin;
import com.ca.core.domain.User;
import com.ca.core.domain.Wallet;
import com.ca.core.exception.EmailException;
import com.ca.core.exception.TaxNumberException;
import com.ca.core.exception.TransactionPinException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private EmailAvailableUseCase emailAvailableUseCase;
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private CreateTransactionPinUseCase createTransactionPinUseCase;
    private CreateWalletUseCase createWalletUseCase;
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(EmailAvailableUseCase emailAvailableUseCase,
                                 TaxNumberAvailableUseCase taxNumberAvailableUseCase,
                                 CreateUserGateway createUserGateway) {
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws EmailException, TaxNumberException, TransactionPinException {
        if (!emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        User createdUser = createUserGateway.create(user);

        createWalletUseCase.create(new Wallet(BigDecimal.ZERO, createdUser));

        var transactionPin = new TransactionPin(createdUser, pin);
        createTransactionPinUseCase.create(transactionPin);
    }
}
