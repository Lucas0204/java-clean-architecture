package com.ca.application.usecaseimpl;

import com.ca.application.gateway.UserAuthenticateGateway;
import com.ca.core.exception.AuthenticationException;
import com.ca.core.exception.enums.ErrorCodeEnum;
import com.ca.usecase.UserAuthenticationUseCase;

public class UserAuthenticationUseCaseImpl implements UserAuthenticationUseCase {
    private final UserAuthenticateGateway userAuthenticateGateway;

    public UserAuthenticationUseCaseImpl(UserAuthenticateGateway userAuthenticateGateway) {
        this.userAuthenticateGateway = userAuthenticateGateway;
    }

    @Override
    public Boolean authenticate(String username, String password) throws AuthenticationException {
        if (!userAuthenticateGateway.authenticate(username, password)) {
            throw new AuthenticationException(ErrorCodeEnum.AUTH0001.getMessage(), ErrorCodeEnum.AUTH0001.getCode());
        }
        return Boolean.TRUE;
    }
}
