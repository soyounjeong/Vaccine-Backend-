package com.project.third_project.controller;

import com.project.third_project.dto.AvailableDateRequest;
import com.project.third_project.entity.availableDate.AvailableDate;
import com.project.third_project.service.AvailableDateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AvailableDateApiController {
    private final AvailableDateService availableDateService;

    @PostMapping("/api/availableDate/")
    public Long save(@RequestBody AvailableDateRequest availableDateRequest){
        return availableDateService.save(availableDateRequest);
    }
}
