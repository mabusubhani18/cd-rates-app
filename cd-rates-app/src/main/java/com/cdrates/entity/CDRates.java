package com.cdrates.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table //represents that it will map to ‘invoice’ table in Cassandra DB.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CDRates {
	
	@PrimaryKey	
    private Integer id;
    @Column(value="apy")
    private Double apy;
    @Column(value="cd_rate")
    private Double cdRate;
    @Column(value="cd_type")
    private String cdType;
    @Column(value="term")
    private String termType;
    @Column(value="max_deposit_amount")
	private Double maxDepositAmount;
    @Column(value="manager_rate")
	private Double managerApy;
    @Column(value="state")
    private String state;
    @Column(value="intrest_rate")
    private Double intrestRate;
    @Column(value="min_deposit_amount")
    private Double minDepositAmount;
}
