package com.project.third_project.service;

import com.project.third_project.dto.AvailableDateRequest;
import com.project.third_project.entity.availableDate.AvailableDate;
import com.project.third_project.entity.availableDate.AvailableDateRepository;
import com.project.third_project.entity.hospital.HospitalRepository;
import com.project.third_project.entity.storage.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AvailableDateService {
    private final AvailableDateRepository availableDateRepository;
    private final HospitalRepository hospitalRepository;
    private final StorageRepository storageRepository;

    @Transactional
    public Long save(AvailableDateRequest availableDateRequest){
        AvailableDate availableDate = AvailableDate.builder()
                .hospital(hospitalRepository.getById(availableDateRequest.getHospitalId()))
                .storage(storageRepository.getById(availableDateRequest.getStorageId()))
                .date(availableDateRequest.getDate())
                .quantity(availableDateRequest.getQuantity())
                .build();
        return availableDateRepository.save(availableDate).getId();
    }
}
