package com.cdrates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.cdrates.exp.InvalidZipCodeException;
import com.cdrates.models.CdRateChart;
import com.cdrates.service.CdRatesService;
import io.swagger.v3.oas.annotations.Operation;

@Controller
public class CdRatesGraphController {

    @Autowired
    private CdRatesService cdRatesService;

    @Operation(
            summary = "Fetch CdRates for customer REST API",
            description = "REST API to fetch cdrates for customer"
    )
    @QueryMapping
    public List<CdRateChart> getActiveCdRates(@Argument String zipCode) {

        if (zipCode.length() == 5) {
            return cdRatesService.getActiveCdRates(zipCode, false);
        } else {
            throw new InvalidZipCodeException(AppContants.INVALID_ZIPCODE);
        }

    }

    @Operation(
            summary = "Fetch Cd History Rates for customer REST API",
            description = "REST API to fetch Cd History Rates for customer"
    )
    @QueryMapping
    public List<CdRateChart> getCdHistoryRateChart(@Argument String zipCode) {

        if (zipCode.length() == 5) {
            return cdRatesService.getActiveCdRates(zipCode, false);
        } else {
            throw new InvalidZipCodeException(AppContants.INVALID_ZIPCODE);
        }
    }

    @Operation(
            summary = "Fetch Cd Rates for Manager REST API",
            description = "REST API to fetch CdRates for Manager"
    )
    @QueryMapping
    public List<CdRateChart> getActiveManagerCDRates(@Argument String zipCode) {

        if (zipCode.length() == 5) {
            return cdRatesService.getActiveCdRates(zipCode, true);
        } else {
            throw new InvalidZipCodeException(AppContants.INVALID_ZIPCODE);
        }
    }

    @Operation(
            summary = "Fetch Cd History Rates for Manager REST API",
            description = "REST API to fetch Cd History Rates for Manager"
    )

    @QueryMapping
    public List<CdRateChart> getActiveManagerHistoryCDRates(@Argument String zipCode) {
        if (zipCode.length() == 5) {
            return cdRatesService.getActiveCdRates(zipCode, true);
        } else {
            throw new InvalidZipCodeException(AppContants.INVALID_ZIPCODE);
        }
    }

}

