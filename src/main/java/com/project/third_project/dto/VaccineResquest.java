package com.project.third_project.dto;

import com.project.third_project.Entity.vaccine.Vaccine;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VaccineResquest {
    private String name;
    private String region;
    private String expiration;

    @Builder
    public VaccineResquest(String name ,String region, String expiration){
        this.name = name;
        this.region = region;
        this.expiration = expiration;
    }

    public Vaccine toEntity(){
        return Vaccine.builder()
                .name(name)
                .region(region)
                .expiration(expiration)
                .build();
    }
}
