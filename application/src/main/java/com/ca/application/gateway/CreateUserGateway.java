package com.ca.application.gateway;

import com.ca.core.domain.User;

public interface CreateUserGateway {
    User create(User user);
}
