package com.project.third_project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservationRequest {
    private Long usersId;
    private Long hospitalId;
    private Long availableDateId;
    private Long availableTimeId;

    @Builder
    public ReservationRequest(Long usersId, Long hospitalId, Long availableDateId, Long availableTimeId){
        this.usersId = usersId;
        this.hospitalId = hospitalId;
        this.availableDateId = availableDateId;
        this.availableTimeId = availableTimeId;
    }
}
