package com.exerciseBCI.model;

public class Telefono {
	private Integer number;
	private Integer cityCode;
	private Integer countryCode;
	
	
	public Telefono(Integer number, Integer cityCode, Integer countryCode) {
		super();
		this.setNumber(number);
		this.setCityCode(cityCode);
		this.setCountryCode(countryCode);
	}

	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public Integer getCityCode() {
		return cityCode;
	}


	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}
	
	public Integer getCountryCode() {
		return countryCode;
	}


	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
}
