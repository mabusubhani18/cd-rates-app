package com.cdrates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdrates.exp.InvalidZipCodeException;
import com.cdrates.models.CdRateChart;
import com.cdrates.service.CdRatesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/v3")
public class CdRatesController {

	@Autowired
	private CdRatesService cdRatesService;

	@Operation(
            summary = "Fetch CdRates for customer REST API",
            description = "REST API to fetch cdrates for customer"
    )
	@GetMapping("/customer/cdRateChart/{zipCode}")
	public List<CdRateChart> getActiveCdRates(@PathVariable String zipCode) {

		if (zipCode.length() == 5) {
			return cdRatesService.getActiveCdRates(zipCode);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode");
		}

	}

	@Operation(
            summary = "Fetch Cd History Rates for customer REST API",
            description = "REST API to fetch Cd History Rates for customer"
    )
	@GetMapping("/customer/cdHistoryRateChart/{zipCode}")
	public List<CdRateChart> getCdHistoryRateChart(@PathVariable String zipCode) {

		if (zipCode.length() == 5) {
			return cdRatesService.getActiveCdRates(zipCode);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode");
		}
	}

	@Operation(
			  summary = "Fetch Cd Rates for Manager REST API",
	          description = "REST API to fetch CdRates for Manager"
    )
	@GetMapping(value = "/manager/cdRateChart/{zipCode}")
	public List<CdRateChart> getActiveManagerCDRates(@PathVariable("zipCode") String zipCode) {
		if (zipCode.length() == 5) {
			return cdRatesService.getActiveManagerCDRates(zipCode);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode");
		}
	}

	@Operation(
			  summary = "Fetch Cd History Rates for Manager REST API",
	          description = "REST API to fetch Cd History Rates for Manager"
    )
	@GetMapping(value = "/manager/cdHistoryRateChart/{zipCode}")
	public List<CdRateChart> getActiveManagerHistoryCDRates(@PathVariable("zipCode") String zipCode) {
		if (zipCode.length() == 5) {
			return cdRatesService.getActiveManagerCDRates(zipCode);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode");
		}
	}

}
