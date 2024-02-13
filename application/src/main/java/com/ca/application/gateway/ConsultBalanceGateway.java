package com.ca.application.gateway;

import com.ca.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceGateway {
    BigDecimal consult(Wallet wallet);
}
