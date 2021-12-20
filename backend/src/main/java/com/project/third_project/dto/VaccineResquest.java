package com.project.third_project.dto;

import com.project.third_project.entity.hospital.Hospital;
import com.project.third_project.entity.vaccine.Vaccine;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VaccineResquest {
    private String name;
    private Long hospitalId;
    private Long quantity;


    @Builder
    public VaccineResquest(String name ,Long hospitalId, Long quantity){
        this.name = name;
        this.hospitalId = hospitalId;
        this.quantity = quantity;
    }

}
