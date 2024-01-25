package com.cdrates.service;

import java.util.List;

import com.cdrates.models.CdRateChart;

public interface CdRatesService {
	
	
	
	public abstract List<CdRateChart> getActiveCdRates(String zipCode);
	public abstract List<CdRateChart> getCdHistoryRateChart(String zipCode);
	public abstract List<CdRateChart> getActiveManagerCDRates(String zipCode);
	public abstract List<CdRateChart> getActiveManagerHistoryCDRates(String zipCode);


}
