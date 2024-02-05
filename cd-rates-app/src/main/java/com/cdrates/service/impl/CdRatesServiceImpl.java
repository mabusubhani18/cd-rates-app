package com.cdrates.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.cdrates.entity.CDRates;
import com.cdrates.models.CdRateChart;
import com.cdrates.models.MetaData;
import com.cdrates.repo.CDRatesRepository;
import com.cdrates.service.CdRatesService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CdRatesServiceImpl implements CdRatesService {

    //Actual values will come from data api
    CDRatesRepository cDRatesRepository;

    @Override
    public List<CdRateChart> getActiveCdRates(String zipCode, boolean isManager) {
        //Retrive record by Id using findByZipCode() method
    	
        int pageSize = 5;

        String state = getState(zipCode);
        List<CDRates> cdRatesResult = cDRatesRepository.findByState(state);
        Slice<CDRates> page = cDRatesRepository.findAll(CassandraPageRequest.of(0, pageSize ));

        List<CdRateChart> cdRateCharts = new ArrayList<>();
        for (CDRates cdRates : cdRatesResult) {
        	CdRateChart cdRateChart = new CdRateChart();
            cdRateChart.setCdType(cdRates.getCdType());
            cdRateChart.setTermType(cdRates.getTermType());
            cdRateChart.setCdMaxAmount(cdRates.getMaxDepositAmount());
            cdRateChart.setCdMinAmount(cdRates.getMinDepositAmount());
            cdRateChart.setIntrestRate(cdRates.getIntrestRate());
            if(isManager) {
                cdRateChart.setManagerApy(cdRates.getManagerApy());
            }else{
                cdRateChart.setApy(cdRates.getApy());
            }
            
            MetaData metaData= new MetaData();
            // total pages
            metaData.setTotalPages(page.getSize());
            // total elements
            metaData.setTotalRecords(page.getNumberOfElements());
            // number of elements
            metaData.setLimit(page.getPageable().toLimit().max());
            int pagTotal=1;       
            while(page.hasNext()) {
                page=cDRatesRepository.findAll(page.nextPageable());
                pagTotal++;
            }
            metaData.setTotalPages(pagTotal);
            metaData.setPageNumber(page.getNumber());
            cdRateChart.setMetaData(metaData);
            cdRateCharts.add(cdRateChart);
        }
       
        return cdRateCharts;
    }

    private String getState(String zipCode) {

        /* Ensure param is a string to prevent unpredictable parsing results */
        if (zipCode == null) {
            return "zipCode can't be null";
        }

        /* Ensure we have exactly 5 characters to parse */
        if (zipCode.length() != 5) {

            return "Must pass a 5-digit zipcode";
        }

        /* Ensure we don't parse strings starting with 0 as octal values */
        int zipcode = Integer.parseInt(zipCode, 10);

        String st;

        /* Code cases alphabetized by state */
        if (zipcode >= 35000 && zipcode <= 36999) {
            st = "AL";//Alabama
        } else if (zipcode >= 99500 && zipcode <= 99999) {
            st = "AK";//Alaska
        } else if (zipcode >= 85000 && zipcode <= 86999) {
            st = "AZ";//Arizona
        } else if (zipcode >= 71600 && zipcode <= 72999) {
            st = "AR";//Arkansas
        } else if (zipcode >= 90000 && zipcode <= 96699) {
            st = "CA";//California
        } else if (zipcode >= 80000 && zipcode <= 81999) {
            st = "CO";//Colorado
        } else if ((zipcode >= 6000 && zipcode <= 6389) || (zipcode >= 6391 && zipcode <= 6999)) {
            st = "CT";//Connecticut
        } else if (zipcode >= 19700 && zipcode <= 19999) {
            st = "DE";//Delaware
        } else if (zipcode >= 32000 && zipcode <= 34999) {
            st = "FL";//Florida
        } else if ((zipcode >= 30000 && zipcode <= 31999) || (zipcode >= 39800 && zipcode <= 39999)) {
            st = "GA";//Georgia
        } else if (zipcode >= 96700 && zipcode <= 96999) {
            st = "HI";//Hawaii
        } else if (zipcode >= 83200 && zipcode <= 83999 && zipcode != 83414) {
            st = "ID";//Idaho
        } else if (zipcode >= 60000 && zipcode <= 62999) {
            st = "IL";//Illinois
        } else if (zipcode >= 46000 && zipcode <= 47999) {
            st = "IN";//Indiana
        } else if (zipcode >= 50000 && zipcode <= 52999) {
            st = "IA";//Iowa
        } else if (zipcode >= 66000 && zipcode <= 67999) {
            st = "KS";//Kansas
        } else if (zipcode >= 40000 && zipcode <= 42999) {
            st = "KY";//Kentucky
        } else if (zipcode >= 70000 && zipcode <= 71599) {
            st = "LA";//Louisiana
        } else if (zipcode >= 3900 && zipcode <= 4999) {
            st = "ME";//Maine
        } else if (zipcode >= 20600 && zipcode <= 21999) {
            st = "MD";//Maryland
        } else if ((zipcode >= 1000 && zipcode <= 2799) || (zipcode == 5501) || (zipcode == 5544)) {
            st = "MA";//Massachusetts
        } else if (zipcode >= 48000 && zipcode <= 49999) {
            st = "MI";//Michigan
        } else if (zipcode >= 55000 && zipcode <= 56899) {
            st = "MN";//Minnesota
        } else if (zipcode >= 38600 && zipcode <= 39999) {
            st = "MS";//Mississippi
        } else if (zipcode >= 63000 && zipcode <= 65999) {
            st = "MO";//Missouri
        } else if (zipcode >= 59000 && zipcode <= 59999) {
            st = "MT";//Montana
        } else if (zipcode >= 27000 && zipcode <= 28999) {
            st = "NC";//North Carolina
        } else if (zipcode >= 58000 && zipcode <= 58999) {
            st = "ND";//North Dakota
        } else if (zipcode >= 68000 && zipcode <= 69999) {
            st = "NE";//Nebraska
        } else if (zipcode >= 88900 && zipcode <= 89999) {
            st = "NV";//Nevada
        } else if (zipcode >= 3000 && zipcode <= 3899) {
            st = "NH";//New Hampshire
        } else if (zipcode >= 7000 && zipcode <= 8999) {
            st = "NJ";//New Jersey
        } else if (zipcode >= 87000 && zipcode <= 88499) {
            st = "NM";//New Mexico
        } else if ((zipcode >= 10000 && zipcode <= 14999) || (zipcode == 6390) || (zipcode == 501)
                || (zipcode == 544)) {
            st = "NY";//New York
        } else if (zipcode >= 43000 && zipcode <= 45999) {
            st = "OH";//Ohio
        } else if ((zipcode >= 73000 && zipcode <= 73199) || (zipcode >= 73400 && zipcode <= 74999)) {
            st = "OK";//Oklahoma
        } else if (zipcode >= 97000 && zipcode <= 97999) {
            st = "OR";//Oregon
        } else if (zipcode >= 15000 && zipcode <= 19699) {
            st = "PA";//Pennsylvania
        } else if (zipcode >= 300 && zipcode <= 999) {
            st = "PR";//Puerto Rico
        } else if (zipcode >= 2800 && zipcode <= 2999) {
            st = "RI";//Rhode Island
        } else if (zipcode >= 29000 && zipcode <= 29999) {
            st = "SC";//South Carolina
        } else if (zipcode >= 57000 && zipcode <= 57999) {
            st = "SD";//South Dakota
        } else if (zipcode >= 37000 && zipcode <= 38599) {
            st = "TN";//Tennessee
        } else if ((zipcode >= 75000 && zipcode <= 79999) || (zipcode >= 73301 && zipcode <= 73399)
                || (zipcode >= 88500 && zipcode <= 88599)) {
            st = "TX";//Texas
        } else if (zipcode >= 84000 && zipcode <= 84999) {
            st = "UT";//Utah
        } else if (zipcode >= 5000 && zipcode <= 5999) {
            st = "VT";//Vermont
        } else if ((zipcode >= 20100 && zipcode <= 20199) || (zipcode >= 22000 && zipcode <= 24699)
                || (zipcode == 20598)) {
            st = "VA";//Virginia
        } else if ((zipcode >= 20000 && zipcode <= 20099) || (zipcode >= 20200 && zipcode <= 20599)
                || (zipcode >= 56900 && zipcode <= 56999)) {
            st = "DC";//Washington DC
        } else if (zipcode >= 98000 && zipcode <= 99499) {
            st = "WA";//Washington
        } else if (zipcode >= 24700 && zipcode <= 26999) {
            st = "WV";//West Virginia
        } else if (zipcode >= 53000 && zipcode <= 54999) {
            st = "WI";//Wisconsin
        } else if ((zipcode >= 82000 && zipcode <= 83199) || zipcode == 83414) {
            st = "WY";//Wyoming
        } else {
            st = "none";
        }
        return st;
    }
}
