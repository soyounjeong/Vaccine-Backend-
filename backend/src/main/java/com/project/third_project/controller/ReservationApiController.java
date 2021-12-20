package com.project.third_project.controller;

import com.project.third_project.dto.ReservationRequest;
import com.project.third_project.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationApiController {
    private final ReservationService reservationService;

    @PostMapping("/api/reservation/")
    public Long save(@RequestBody ReservationRequest reservationRequest){
        return reservationService.save(reservationRequest);
    }
}
