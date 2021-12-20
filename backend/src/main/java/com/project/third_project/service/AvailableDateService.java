package com.project.third_project.service;

import com.project.third_project.dto.AvailableDateRequest;
import com.project.third_project.dto.AvailableDateListResponse;
import com.project.third_project.entity.availableDate.AvailableDate;
import com.project.third_project.entity.availableDate.AvailableDateRepository;
import com.project.third_project.entity.hospital.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailableDateService {
    private final AvailableDateRepository availableDateRepository;
    private final HospitalRepository hospitalRepository;

    @Transactional
    public Long save(AvailableDateRequest availableDateRequest){
        AvailableDate availableDate = AvailableDate.builder()
                .hospital(hospitalRepository.getById(availableDateRequest.getHospitalId()))
                .date(availableDateRequest.getDate())
                .quantity(availableDateRequest.getQuantity())
                .build();
        return availableDateRepository.save(availableDate).getId();
    }

    public List<AvailableDateListResponse> availableDateList(Long hospitalId){
        List<AvailableDate> availableDateList = availableDateRepository.findAllByHospitalId(hospitalId);
        List<AvailableDateListResponse> availableDateListResponses = availableDateList.stream()
                .map(availableDate -> {
                    AvailableDateListResponse availableDateListResponse = AvailableDateListResponse.builder()
                            .date(availableDate.getDate())
                            .build();
                    return availableDateListResponse;
                }).collect(Collectors.toList());
        return  availableDateListResponses;
    }
}
