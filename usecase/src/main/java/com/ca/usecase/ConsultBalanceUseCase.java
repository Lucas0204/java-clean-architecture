package com.ca.usecase;

import com.ca.core.domain.Wallet;

import java.math.BigDecimal;

public interface ConsultBalanceUseCase {
    BigDecimal consult(Wallet wallet);
}
