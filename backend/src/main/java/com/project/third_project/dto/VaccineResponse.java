package com.project.third_project.dto;

import com.project.third_project.entity.vaccine.Vaccine;
import lombok.Getter;

@Getter
public class VaccineResponse {
    private String name;
    private Long hospitalId;
    private Long quantity;

    public VaccineResponse(Vaccine vaccine){
        this.name = vaccine.getName();
        this.hospitalId = vaccine.getHospital().getId();
        this.quantity = vaccine.getQuantity();
    }
}
