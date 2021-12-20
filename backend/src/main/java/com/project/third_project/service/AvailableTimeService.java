package com.project.third_project.service;

import com.project.third_project.dto.AvailableDateListResponse;
import com.project.third_project.dto.AvailableTimeListResponse;
import com.project.third_project.dto.AvailableTimeRequest;
import com.project.third_project.entity.abailableTime.AvailableTime;
import com.project.third_project.entity.abailableTime.AvailableTimeRepository;
import com.project.third_project.entity.availableDate.AvailableDateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailableTimeService {
    private final AvailableTimeRepository availableTimeRepository;
    private final AvailableDateRepository availableDateRepository;


    @Transactional
    public Long save(AvailableTimeRequest availableTimeRequest){
        System.out.println(availableTimeRequest.getAvailableDateId());
        AvailableTime availableTime = AvailableTime.builder()
                .availableDate(availableDateRepository.getById(availableTimeRequest.getAvailableDateId()))
                .time(availableTimeRequest.getTime())
                .quantity(availableTimeRequest.getQuantity())
                .build();
        return availableTimeRepository.save(availableTime).getId();
    }

    public List<AvailableTimeListResponse> availableTimeList(Long hospitalId){
        List<AvailableTime> availableTimeList = availableTimeRepository.findAllByAvailableDateId(hospitalId);
        List<AvailableTimeListResponse> availableTimeListResponses = availableTimeList.stream()
                .map(availableTime -> {
                    AvailableTimeListResponse availableTimeListResponse = AvailableTimeListResponse.builder()
                            .time(availableTime.getTime())
                            .build();
                    return  availableTimeListResponse;
                }).collect(Collectors.toList());
        return availableTimeListResponses;
    }

}
