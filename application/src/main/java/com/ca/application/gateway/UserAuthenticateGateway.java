package com.ca.application.gateway;

import com.ca.core.domain.TransactionPin;
import com.ca.core.domain.User;
import com.ca.core.domain.Wallet;

public interface UserAuthenticateGateway {
    Boolean authenticate(String username, String password);
}
