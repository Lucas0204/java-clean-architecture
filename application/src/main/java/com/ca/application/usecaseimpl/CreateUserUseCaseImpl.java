package com.ca.application.usecaseimpl;

import com.ca.application.gateway.CreateUserGateway;
import com.ca.core.domain.TransactionPin;
import com.ca.core.domain.User;
import com.ca.core.domain.Wallet;
import com.ca.core.exception.CreateUserException;
import com.ca.core.exception.EmailException;
import com.ca.core.exception.TaxNumberException;
import com.ca.core.exception.TransactionPinException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.*;

import java.math.BigDecimal;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private EmailAvailableUseCase emailAvailableUseCase;
    private TaxNumberAvailableUseCase taxNumberAvailableUseCase;
    private CreateUserGateway createUserGateway;

    public CreateUserUseCaseImpl(EmailAvailableUseCase emailAvailableUseCase,
                                 TaxNumberAvailableUseCase taxNumberAvailableUseCase,
                                 CreateUserGateway createUserGateway) {
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws EmailException, TaxNumberException, TransactionPinException, CreateUserException {
        if (!emailAvailableUseCase.emailAvailable(user.getEmail())) {
            throw new EmailException(ErrorCodeEnum.ON0003.getMessage(), ErrorCodeEnum.ON0003.getCode());
        }

        if (!taxNumberAvailableUseCase.taxNumberAvailable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErrorCodeEnum.ON0002.getMessage(), ErrorCodeEnum.ON0002.getCode());
        }

        var userWallet = new Wallet(BigDecimal.ZERO, user);
        var userTransactionPin = new TransactionPin(user, pin);
        Boolean userCreated = createUserGateway.create(user, userWallet, userTransactionPin);

        if (!userCreated) {
            throw new CreateUserException(ErrorCodeEnum.ON0004.getMessage(), ErrorCodeEnum.ON0004.getCode());
        }
    }
}
