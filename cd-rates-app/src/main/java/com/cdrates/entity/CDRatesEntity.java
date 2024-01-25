package com.cdrates.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table //represents that it will map to ‘invoice’ table in Cassandra DB.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CDRatesEntity {
	
	@PrimaryKey	
    private Integer id;
    private Double apy;
    private Double cdRate;
    private String cdType;
    private String termType;
	private Double cdMinAmount;
	private Double cdMaxAmount;
	private Double managerApy;

}
