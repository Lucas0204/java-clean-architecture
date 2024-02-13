package com.ca.usecase;

import com.ca.core.domain.Wallet;
import com.ca.core.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {
    Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException;
}
