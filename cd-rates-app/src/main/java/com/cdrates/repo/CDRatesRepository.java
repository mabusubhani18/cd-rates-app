package com.cdrates.repo;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.cdrates.entity.CDRates;


public interface CDRatesRepository extends CassandraRepository<CDRates, String> {
	
	@AllowFiltering
    List<CDRates> findByState(String state);
     
}
