package com.cdrates.models;

import com.cdrates.entity.CDRates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Term {

	private String termType;

	private Double cdMinAmount;

	private Double cdMaxAmount;

	private Double apy;

	private Double managerApy;

	
}
