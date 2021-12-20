package com.project.third_project.dto;

import com.project.third_project.entity.vaccine.Vaccine;
import lombok.Getter;

@Getter
public class VaccineResponse {
    private String name;
    private String region;
    private String expiration;

    public VaccineResponse(Vaccine vaccine){
        this.name = vaccine.getName();
        this.region = vaccine.getRegion();
        this.expiration = vaccine.getExpiration();
    }
}
