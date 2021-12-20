package com.project.third_project.service;


import com.project.third_project.entity.hospital.HospitalRepository;
import com.project.third_project.entity.storage.Storage;
import com.project.third_project.entity.storage.StorageRepository;
import com.project.third_project.entity.vaccine.VaccineRepository;
import com.project.third_project.dto.StorageRequest;
import com.project.third_project.dto.StorageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageRepository storageRepository;
    private final HospitalRepository hospitalRepository;
    private final VaccineRepository vaccineRepository;

    @Transactional
    public Long save(StorageRequest storageRequest){
        Storage storage = Storage.builder()
                .hospital(hospitalRepository.getById(storageRequest.getHospitalId()))
                .vaccine(vaccineRepository.getById(storageRequest.getVaccineId()))
                .quantity(storageRequest.getQuantity())
                .build();
        return storageRepository.save(storage).getId();
    }

    public StorageResponse findById(Long id){
        Storage storage = storageRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 유저 없음"));
        return new StorageResponse(storage);
    }

    @Transactional
    public Long update(Long id, StorageRequest storageRequest){
        Storage storage = storageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저 없음"));
        storage.update(hospitalRepository.getById(storageRequest.getHospitalId()), vaccineRepository.getById(storageRequest.getVaccineId()), storageRequest.getQuantity());
        return  id;
    }

    @Transactional
    public void delete(Long id){
        Storage storage = storageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 유저x"));
        storageRepository.delete(storage);
    }
}
