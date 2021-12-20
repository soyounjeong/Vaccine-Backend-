package com.project.third_project.controller;

import com.project.third_project.dto.AvailableDateRequest;
import com.project.third_project.dto.AvailableTimeListResponse;
import com.project.third_project.dto.AvailableTimeRequest;
import com.project.third_project.service.AvailableTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AvailableTimeApiController {
    private final AvailableTimeService availableTimeService;

    @PostMapping("/api/availableTime/")
    public Long save(@RequestBody AvailableTimeRequest availableTimeRequest){
        return availableTimeService.save(availableTimeRequest);
    }

    @GetMapping("/api/availableTimeList/{hospitalId}")
    public List<AvailableTimeListResponse> AvailableTimeList(@PathVariable Long hospitalId){
        return availableTimeService.availableTimeList(hospitalId);
    }
}
