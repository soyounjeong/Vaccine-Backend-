package com.project.third_project.dto;

import com.project.third_project.entity.availableDate.AvailableDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AvailableDateRequest {
    private Long hospitalId;
    private Long storageId;
    private String date;
    private Long quantity;

    @Builder
    public AvailableDateRequest(Long hospitalId, Long storageId, String date, Long quantity){
        this.hospitalId = hospitalId;
        this.storageId = storageId;
        this.date = date;
        this.quantity = quantity;
    }

}
