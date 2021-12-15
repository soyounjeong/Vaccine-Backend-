package com.project.third_project.dto;

import com.project.third_project.entity.hospital.Hospital;
import lombok.Getter;


@Getter

public class HospitalResponse {
    private String name;
    private String address;
    private String hp;

    public HospitalResponse(Hospital entity){
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.hp = entity.getHp();
    }
}
