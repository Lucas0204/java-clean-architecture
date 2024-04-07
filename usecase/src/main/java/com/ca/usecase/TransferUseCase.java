package com.ca.usecase;

import com.ca.core.exception.*;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws TransferException, NotFoundException, NotificationException, TransactionException, PinException;
}
