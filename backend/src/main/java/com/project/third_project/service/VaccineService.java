package com.project.third_project.service;

import com.project.third_project.entity.hospital.HospitalRepository;
import com.project.third_project.entity.vaccine.Vaccine;
import com.project.third_project.entity.vaccine.VaccineRepository;
import com.project.third_project.dto.VaccineResponse;
import com.project.third_project.dto.VaccineResquest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class VaccineService {
    private final VaccineRepository vaccineRepository;
    private final HospitalRepository hospitalRepository;

    public VaccineResponse findById(Long id){
        Vaccine vaccine = vaccineRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 유저 없음"));
        return new VaccineResponse(vaccine);
    }

    @Transactional
    public Long save(VaccineResquest vaccineResquest){
        Vaccine vaccine = Vaccine.builder()
                .name(vaccineResquest.getName())
                .hospital(hospitalRepository.getById(vaccineResquest.getHospitalId()))
                .quantity(vaccineResquest.getQuantity())
                .build();
        return vaccineRepository.save(vaccine).getId();
    }

    @Transactional
    public Long update(Long id, VaccineResquest vaccineResquest){
        Vaccine vaccine = vaccineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("계정 없음"));
        vaccine.update(vaccineResquest.getName(), hospitalRepository.getById(vaccineResquest.getHospitalId()), vaccineResquest.getQuantity());
        return id;
    }

    @Transactional
    public void delete(Long id){
        Vaccine vaccine = vaccineRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("계정 x"));
        vaccineRepository.delete(vaccine);
    }
}
