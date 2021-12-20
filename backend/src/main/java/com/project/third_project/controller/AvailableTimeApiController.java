package com.project.third_project.controller;

import com.project.third_project.dto.AvailableDateRequest;
import com.project.third_project.dto.AvailableTimeRequest;
import com.project.third_project.service.AvailableTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AvailableTimeApiController {
    private final AvailableTimeService availableTimeService;

    @PostMapping("/api/availableTime/")
    public Long save(@RequestBody AvailableTimeRequest availableTimeRequest){
        return availableTimeService.save(availableTimeRequest);
    }
}
