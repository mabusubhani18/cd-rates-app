package com.cdrates.service;

import java.util.List;

import com.cdrates.models.CdRateChart;

public interface CdRatesService {
	
	
	
	public abstract List<CdRateChart> getActiveCdRates(String zipCode, boolean isManager);



}
