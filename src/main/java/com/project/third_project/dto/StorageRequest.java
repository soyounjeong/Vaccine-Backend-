package com.project.third_project.dto;

import com.project.third_project.Entity.hospital.Hospital;
import com.project.third_project.Entity.storage.Storage;
import com.project.third_project.Entity.vaccine.Vaccine;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class StorageRequest {
    private Hospital hospital;
    private Vaccine vaccine;
    private Long quantity;

    @Builder
    public StorageRequest(Hospital hospital, Vaccine vaccine, Long quantity){
        this.hospital = hospital;
        this.vaccine = vaccine;
        this.quantity = quantity;
    }

    public Storage toEntity(){
        return Storage.builder()
                .hospital(hospital)
                .vaccine(vaccine)
                .quantity(quantity)
                .build();
    }
}
