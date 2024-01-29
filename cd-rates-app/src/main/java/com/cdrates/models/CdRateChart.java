package com.cdrates.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CdRateChart {
    private String cdType;
    private String termType;
    private Double cdMinAmount;
    private Double cdMaxAmount;
    private Double apy;
    private Double managerApy;

    public CdRateChart() {
    }

    public String getCdType() {
        return cdType;
    }

    public void setCdType(String cdType) {
        this.cdType = cdType;
    }

    public String getTermType() {
        return termType;
    }

    public void setTermType(String termType) {
        this.termType = termType;
    }

    public Double getCdMinAmount() {
        return cdMinAmount;
    }

    public void setCdMinAmount(Double cdMinAmount) {
        this.cdMinAmount = cdMinAmount;
    }

    public Double getCdMaxAmount() {
        return cdMaxAmount;
    }

    public void setCdMaxAmount(Double cdMaxAmount) {
        this.cdMaxAmount = cdMaxAmount;
    }

    public Double getApy() {
        return apy;
    }

    public void setApy(Double apy) {
        this.apy = apy;
    }

    public Double getManagerApy() {
        return managerApy;
    }

    public void setManagerApy(Double managerApy) {
        this.managerApy = managerApy;
    }

    public CdRateChart(String cdType, String termType, Double cdMinAmount, Double cdMaxAmount, Double apy, Double managerApy) {
        this.cdType = cdType;
        this.termType = termType;
        this.cdMinAmount = cdMinAmount;
        this.cdMaxAmount = cdMaxAmount;
        this.apy = apy;
        this.managerApy = managerApy;
    }

    @Override
    public String toString() {
        return "CdRateChart{" +
                "cdType='" + cdType + '\'' +
                ", termType='" + termType + '\'' +
                ", cdMinAmount=" + cdMinAmount +
                ", cdMaxAmount=" + cdMaxAmount +
                ", apy=" + apy +
                ", managerApy=" + managerApy +
                '}';
    }


}
