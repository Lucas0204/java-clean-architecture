package com.ca.usecase;

import com.ca.core.exception.AuthenticationException;

public interface UserAuthenticationUseCase {
    Boolean authenticate(String username, String password) throws AuthenticationException;
}
