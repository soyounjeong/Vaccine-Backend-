package com.project.third_project.dto;

import com.project.third_project.entity.availableDate.AvailableDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AvailableTimeRequest {
    private Long availableDateId;
    private String time;
    private Long quantity;

    @Builder
    public AvailableTimeRequest(Long availableDateId, String time, Long quantity){
        this.availableDateId = availableDateId;
        this.time = time;
        this.quantity = quantity;
    }
}
