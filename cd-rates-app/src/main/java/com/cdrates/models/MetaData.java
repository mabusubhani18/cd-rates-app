package com.cdrates.models;

import org.springframework.data.domain.Limit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MetaData {	
	private int pageNumber;
	private int limit;
	private int totalPages;
	private int totalRecords;
}
