package com.cdrates.exp;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CdRatesExceptionHandler {
	
	@ExceptionHandler(value=InvalidZipCodeException.class)
	public ResponseEntity<ExpInfo> handleInvalidZipCode(Exception e){
		
		ExpInfo ex= new ExpInfo();
		ex.setExpCode("0001_INVALID");
		ex.setExpMsg(e.getMessage());
		ex.setDate(LocalDate.now());
		
		return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
		
	}

}
