package com.ca.application.gateway;

import com.ca.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findByTaxNumber(String taxNumber);
}
