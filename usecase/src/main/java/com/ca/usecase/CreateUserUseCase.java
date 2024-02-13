package com.ca.usecase;

import com.ca.core.domain.User;
import com.ca.core.exception.CreateUserException;
import com.ca.core.exception.EmailException;
import com.ca.core.exception.TaxNumberException;
import com.ca.core.exception.TransactionPinException;

public interface CreateUserUseCase {
    void create(User user, String pin) throws EmailException, TaxNumberException, TransactionPinException, CreateUserException;
}
