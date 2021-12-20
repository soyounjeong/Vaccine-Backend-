package com.project.third_project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
