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
    private Long hospitalId;
    private Long vaccineId;
    private Long quantity;

    @Builder
    public StorageRequest(Long hospitalId, Long vaccineId, Long quantity){
        this.hospitalId = hospitalId;
        this.vaccineId = vaccineId;
        this.quantity = quantity;
    }


}
