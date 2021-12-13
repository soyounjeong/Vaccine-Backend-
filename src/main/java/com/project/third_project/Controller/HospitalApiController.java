package com.project.third_project.Controller;

import com.project.third_project.Service.HospitalService;
import com.project.third_project.dto.HospitalRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor // service 클래스에 의존성 주입
// 의존성 주입

public class HospitalApiController {
    private final HospitalService hospitalService;

    @PostMapping("/api/hospital")
    public Long save(@RequestBody HospitalRequest hospitalRequest){
        return hospitalService.save(hospitalRequest);
    }
}
