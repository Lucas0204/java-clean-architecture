package com.ca.application.usecaseimpl;

import com.ca.application.gateway.TaxNumberAvailableGateway;
import com.ca.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {
    private TaxNumberAvailableGateway taxNumberAvailableGateway;

    @Override
    public Boolean taxNumberAvailable(String taxNumber) {
        return taxNumberAvailableGateway.taxNumberAvailable(taxNumber);
    }
}
