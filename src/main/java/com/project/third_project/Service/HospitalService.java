package com.project.third_project.Service;

import com.project.third_project.Entity.hospital.HospitalRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRespository hospitalRespitory;



}
