package com.exerciseBCI.entity;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long number;
    private Integer cityCode;
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    public PhoneEntity() {
        super();
    }

    public PhoneEntity(Long number, Integer cityCode, String countryCode, UserEntity user) {
        super();
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.user = user;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
