package com.cdrates.repo;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.cdrates.entity.CDRates;

import java.util.List;

@Repository
public interface CDRatesRepository extends CassandraRepository<CDRates, String> {
	
	@AllowFiltering
     List<CDRates> findByState(String state);

}
