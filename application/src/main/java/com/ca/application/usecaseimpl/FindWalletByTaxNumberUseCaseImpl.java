package com.ca.application.usecaseimpl;

import com.ca.application.gateway.FindWalletByTaxNumberGateway;
import com.ca.core.domain.Wallet;
import com.ca.core.exception.NotFoundException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.FindWalletByTaxNumberUseCase;

import java.util.Objects;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {
    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException {
        Wallet wallet = findWalletByTaxNumberGateway.findByTaxNumber(taxNumber);
        if (Objects.isNull(wallet)) {
            throw new NotFoundException(ErrorCodeEnum.WA0001.getMessage(), ErrorCodeEnum.WA0001.getCode());
        }
        return wallet;
    }
}
