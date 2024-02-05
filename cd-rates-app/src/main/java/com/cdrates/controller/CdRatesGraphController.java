package com.cdrates.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdrates.exp.InvalidZipCodeException;
import com.cdrates.models.CdRateChart;
import com.cdrates.service.CdRatesService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CdRatesGraphController {

	
	private CdRatesService cdRatesService;


	@QueryMapping
	public List<CdRateChart> getActiveCdRates(@Argument String zipCode) {

		if (zipCode.length() == 5) {
			return cdRatesService.getActiveCdRates(zipCode, false);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode get actiev CD Rate");
		}

	}


	@QueryMapping
	public List<CdRateChart> getCdHistoryRateChart(@Argument String zipCode) {

		if (zipCode.length() == 5) {
			return cdRatesService.getActiveCdRates(zipCode, false);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode get Cd History RateChart");
		}
	}


	@QueryMapping
	public List<CdRateChart> getActiveManagerCDRates(@Argument("zipCode") String zipCode) {

		if (zipCode.length() == 5) {
			return cdRatesService.getActiveCdRates(zipCode,true);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode");
		}
	}

	
	@QueryMapping
	public List<CdRateChart> getActiveManagerHistoryCDRates(@Argument("zipCode") String zipCode) {
		if (zipCode.length() == 5) {
			return cdRatesService.getActiveCdRates(zipCode,true);
		} else {
			throw new InvalidZipCodeException("Invalid Zipcode");
		}
	}

}
