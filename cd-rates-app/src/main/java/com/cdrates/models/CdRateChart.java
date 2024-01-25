package com.cdrates.models;

import java.util.List;

public class CdRateChart {
	
	  private String cdType;
	  private List<Term> terms;
	  
	public String getCdType() {
		return cdType;
	}
	public void setCdType(String cdType) {
		this.cdType = cdType;
	}
	public List<Term> getTerms() {
		return terms;
	}
	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}
	public CdRateChart(String cdType, List<Term> terms) {
		this.cdType = cdType;
		this.terms = terms;
	}
	
	@Override
	public String toString() {
		return "CdRateChart [cdType=" + cdType + ", terms=" + terms + "]";
	}
	
	

	
}
