package com.cdrates.service.impl;

import com.cdrates.entity.CDRates;
import com.cdrates.models.CdRateChart;
import com.cdrates.repo.CDRatesRepository;
import com.cdrates.service.CdRatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class CdRatesServiceImpl implements CdRatesService {

    //Actual values will come from data api
    @Autowired
    CDRatesRepository cDRatesRepository;

    @Override
    public List<CdRateChart> getActiveCdRates(String zipCode) {
        //Retrive record by Id using findByZipCode() method
        List<CDRates> cdRatesResult = cDRatesRepository.findByZipCode(Integer.valueOf(zipCode));

        List<CdRateChart> cdRateCharts = new ArrayList<>();
        for (CDRates cdRates : cdRatesResult) {
            CdRateChart cdRateChart = new CdRateChart();
            cdRateChart.setCdType(cdRates.getCdType());
            cdRateChart.setApy(cdRates.getApy());
            cdRateChart.setTermType(cdRates.getTermType());
            cdRateChart.setCdMaxAmount(cdRates.getCdMaxAmount());
            cdRateChart.setManagerApy(cdRates.getManagerApy());
            cdRateChart.setCdMinAmount(cdRates.getCdMinAmount());
            cdRateCharts.add(cdRateChart);
        }
        System.out.println("cdRateCharts" + cdRateCharts);
        return cdRateCharts;
    }

    @Override
    public List<CdRateChart> getCdHistoryRateChart(String zipCode) {
        return getActiveCdRates(zipCode);
    }

    @Override
    public List<CdRateChart> getActiveManagerCDRates(String zipCode) {
        List<CDRates> cdRatesResult = cDRatesRepository.findByZipCode(Integer.valueOf(zipCode));

        List<CdRateChart> cdRateCharts = new ArrayList<>();
        for (CDRates cdRates : cdRatesResult) {
            CdRateChart cdRateChart = new CdRateChart();
            cdRateChart.setCdType(cdRates.getCdType());
            cdRateChart.setApy(cdRates.getApy());
            cdRateChart.setTermType(cdRates.getTermType());
            cdRateChart.setCdMaxAmount(cdRates.getCdMaxAmount());
            cdRateChart.setManagerApy(cdRates.getManagerApy());
            cdRateChart.setCdMinAmount(cdRates.getCdMinAmount());
            cdRateCharts.add(cdRateChart);
        }
        System.out.println("cdRateCharts" + cdRateCharts);
        return cdRateCharts;
    }

    @Override
    public List<CdRateChart> getActiveManagerHistoryCDRates(String zipCode) {
        return getActiveManagerCDRates(zipCode);
    }
}
