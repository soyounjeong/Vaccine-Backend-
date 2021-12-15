package com.project.third_project.dto;

import com.project.third_project.Entity.storage.Storage;
import lombok.Getter;

@Getter
public class StorageResponse {
    private Long hospitalId;
    private Long vaccineId;
    private Long quantity;

    public StorageResponse(Storage storage){
        this.hospitalId = storage.getHospital().getId();
        this.vaccineId = storage.getVaccine().getId();
        this.quantity = storage.getQuantity();
    }

}
