package com.cdrates.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CdRateChart {
    private String cdType;
    private String termType;
    private Double cdMinAmount;
    private Double cdMaxAmount;
    private Double apy;
    private Double managerApy;
    private Double intrestRate;    
    MetaData metaData;
}
