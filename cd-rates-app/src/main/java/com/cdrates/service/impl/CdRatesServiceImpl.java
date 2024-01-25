package com.cdrates.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdrates.entity.CDRates;
import com.cdrates.models.CdRateChart;
import com.cdrates.models.Term;
import com.cdrates.repo.CDRatesRepository;
import com.cdrates.service.CdRatesService;

import lombok.AllArgsConstructor;

@Service
//@AllArgsConstructor
public class CdRatesServiceImpl implements CdRatesService{

	//Actual values will come from data api
	@Autowired
	CDRatesRepository cDRatesRepository;
	
	@Override
	public List<CdRateChart> getActiveCdRates(String zipCode) {
		
		
		 Term t1 = new Term("1", 250.0, 10000d, 0.2, 0.15); 
		 Term t2 = new Term("2",250.0, 5000d, 0.1, 0.15); 
		 Term t3 = new Term("3", 250.0, 8000d, 0.3, 0.5);
		  
		  List<Term> terms = Arrays.asList(t1,t2,t3);
		  CdRateChart cdRateChartList= new CdRateChart("Standard", terms);
		 
		//Optional<CDRatesEntity> optionalCDRates=cDRatesRepository.findById(111);
		//System.out.println("CDRates Data  ========>  "+optionalCDRates.get());

	      //Retrive record by Id using findById() method
	      Optional<CDRates> opt= cDRatesRepository.findById(111);
	      if(opt.isPresent()) {
	           System.out.println(opt.get());;
	      }
		
		return Arrays.asList(cdRateChartList);
	}

	@Override
	public List<CdRateChart> getCdHistoryRateChart(String zipCode) {
	
		return getActiveCdRates(zipCode);
		
	}
	
	@Override
	public  List<CdRateChart> getActiveManagerCDRates(String zipCode){
        Term m1 = new Term("1", 100d, 120d, 0.2, 0.15);
        Term m2 = new Term("2", 150d, 200d, 0.2, 0.17);
 
        List<Term> terms = Arrays.asList(m1);
        CdRateChart cdRateChartList= new CdRateChart("Trade UP", terms);
 
        return Arrays.asList(cdRateChartList);
    }
	
	@Override
	public  List<CdRateChart> getActiveManagerHistoryCDRates(String zipCode){
	return getActiveManagerCDRates(zipCode);
	}
	
	
  
}
