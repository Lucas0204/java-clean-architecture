package com.ca.application.gateway;

import com.ca.core.domain.Wallet;

public interface EmailAvailableGateway {
    Boolean emailAvailable(String email);
}
