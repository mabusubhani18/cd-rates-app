package com.cdrates.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.cdrates.entity.CDRatesEntity;

@Repository
public interface CDRatesRepository extends CassandraRepository<CDRatesEntity, Integer> {
	
	//@AllowFiltering
	//List<CDRatesEntity> findByName(String name);

}
