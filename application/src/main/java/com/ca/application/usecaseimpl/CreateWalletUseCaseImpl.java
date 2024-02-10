package com.ca.application.usecaseimpl;

import com.ca.application.gateway.CreateWalletGateway;
import com.ca.core.domain.Wallet;
import com.ca.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {
    private CreateWalletGateway createWalletGateway;
    @Override
    public void create(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
