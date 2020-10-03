package com.exerciseBCI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONO")
public class TelefonoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer number;
	private Integer cityCode;
	private Integer countryCode;
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private UsuarioEntity usuario;
	
	public TelefonoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TelefonoEntity(Integer number, Integer cityCode, Integer countryCode, UsuarioEntity usuario) {
		super();
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
		this.usuario = usuario;
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
	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
	
}
