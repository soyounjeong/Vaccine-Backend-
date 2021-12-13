package com.project.third_project.Service;

import com.project.third_project.Entity.hospital.HospitalRepository;
import com.project.third_project.dto.HospitalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRespitory;

    @Transactional
    public Long save(HospitalRequest hospitalRequest){
        return hospitalRespitory.save(hospitalRequest.toEntity()).getId();
    }

}
