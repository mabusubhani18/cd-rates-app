package com.cdrates.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.cdrates.entity.CDRates;

@Repository
public interface CDRatesRepository extends CassandraRepository<CDRates, Integer> {
	
	//@AllowFiltering
	//List<CDRatesEntity> findByName(String name);

}
