package com.project.third_project.dto;

import com.project.third_project.Entity.hospital.Hospital;
import lombok.Builder;
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
