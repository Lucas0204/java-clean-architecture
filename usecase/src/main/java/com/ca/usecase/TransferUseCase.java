package com.ca.usecase;

import com.ca.core.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
