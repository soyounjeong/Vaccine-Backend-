package com.project.third_project.service;

import com.project.third_project.entity.hospital.Hospital;
import com.project.third_project.entity.hospital.HospitalRepository;
import com.project.third_project.dto.HospitalRequest;
import com.project.third_project.dto.HospitalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    @Transactional
    public Long save(HospitalRequest hospitalRequest){
        return hospitalRepository.save(hospitalRequest.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, HospitalRequest hospitalRequest){
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));
        // findById => 영속성컨텍스트 때문에 영구저장됨
        hospital.update(hospitalRequest.getName(), hospitalRequest.getAddress(), hospitalRequest.getHp());
        return id;
    }

    @Transactional
    public void delete(Long id){
        Hospital hospital = hospitalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없습니다 id="+id));
        hospitalRepository.delete(hospital);
    }

    public HospitalResponse findById(Long id){
        Hospital entity = hospitalRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new HospitalResponse(entity);
    }

    

}
