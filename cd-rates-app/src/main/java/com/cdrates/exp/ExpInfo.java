package com.cdrates.exp;

import java.time.LocalDate;

public class ExpInfo {
	
	private String expCode;
	
	private String expMsg;
	
	private LocalDate date;

	public String getExpCode() {
		return expCode;
	}

	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}

	public String getExpMsg() {
		return expMsg;
	}

	public void setExpMsg(String expMsg) {
		this.expMsg = expMsg;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
