package com.exerciseBCI.entity;

import com.exerciseBCI.dto.PhoneDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter @Setter
@NoArgsConstructor
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


    public PhoneEntity(Long number, Integer cityCode, String countryCode, UserEntity user) {
        super();
        this.number = number;
        this.cityCode = cityCode;
        this.countryCode = countryCode;
        this.user = user;
    }

    public static List<PhoneEntity> from(List<PhoneDTO> phones, UserEntity userEntity) {
        return phones.stream().map(phoneDTO -> new PhoneEntity(phoneDTO.getNumber(), phoneDTO.getCityCode(),
                phoneDTO.getCountryCode(), userEntity)).collect(Collectors.toList());
    }

}
