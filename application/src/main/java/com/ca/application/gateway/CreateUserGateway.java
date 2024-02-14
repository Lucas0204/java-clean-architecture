package com.ca.application.gateway;

import com.ca.core.domain.TransactionPin;
import com.ca.core.domain.User;
import com.ca.core.domain.Wallet;

public interface CreateUserGateway {
    Boolean create(User user, Wallet wallet);
}
