package com.ca.application.gateway;

import com.ca.core.domain.Transaction;
import com.ca.core.domain.TransactionPin;
import com.ca.core.domain.User;
import com.ca.core.domain.Wallet;

public interface UserNotificationGateway {
    Boolean notificate(Transaction transaction, String email);
}
