package com.ca.usecase;

public interface UserAuthenticationUseCase {
    Boolean authenticate(String username, String password);
}
