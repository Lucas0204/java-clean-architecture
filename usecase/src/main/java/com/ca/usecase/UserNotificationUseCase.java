package com.ca.usecase;

import com.ca.core.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificate(Transaction transaction, String email);
}
