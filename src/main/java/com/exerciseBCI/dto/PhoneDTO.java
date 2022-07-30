package com.exerciseBCI.dto;

public class PhoneDTO {
	private Long number;
	private Integer cityCode;
	private String countryCode;
	
	public PhoneDTO() {
		super();
	}
	
	public PhoneDTO(Long number, Integer cityCode, String countryCode) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Integer getCityCode() {
		return cityCode;
	}

	public void setCityCode(Integer cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	
	
	
	
}
