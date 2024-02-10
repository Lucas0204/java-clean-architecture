package com.ca.application.usecaseimpl;

import com.ca.application.gateway.EmailAvailableGateway;
import com.ca.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {
    private EmailAvailableGateway emailAvailableGateway;

    @Override
    public Boolean emailAvailable(String email) {
        return emailAvailableGateway.emailAvailable(email);
    }
}
