package com.ca.usecase;

import com.ca.core.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findUserByTaxNumber(String taxNumber);
}
