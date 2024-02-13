package com.ca.usecase;

import com.ca.core.exception.NotFoundException;
import com.ca.core.exception.NotificationException;
import com.ca.core.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws TransferException, NotFoundException, NotificationException;
}
