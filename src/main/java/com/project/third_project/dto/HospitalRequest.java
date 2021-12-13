package com.project.third_project.dto;

import com.project.third_project.Entity.hospital.Hospital;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class HospitalRequest {
    private String name;
    private String address;
    private String hp;

    @Builder
    public HospitalRequest(String name, String address, String hp){
        this.name = name;
        this.address = address;
        this.hp = hp;
    }


    public Hospital toEntity(){
        return Hospital.builder()
                .name(name)
                .address(address)
                .hp(hp)
                .build();
    }

}
