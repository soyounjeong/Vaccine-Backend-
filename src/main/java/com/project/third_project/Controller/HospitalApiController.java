package com.project.third_project.Controller;

import com.project.third_project.Service.HospitalService;
import com.project.third_project.dto.HospitalRequest;
import com.project.third_project.dto.HospitalResponse;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // service 클래스에 의존성 주입
// 의존성 주입

public class HospitalApiController {
    private final HospitalService hospitalService;

    @GetMapping("/api/hospital/{id}")
    public HospitalResponse findById(@PathVariable Long id){
        return hospitalService.findById(id);
    }

    @PostMapping("/api/hospital")
    public Long save(@RequestBody HospitalRequest hospitalRequest){
        return hospitalService.save(hospitalRequest);
    }

    @PutMapping("/api/hospital/{id}")
    public Long update(@PathVariable Long id, @RequestBody HospitalRequest hospitalRequest){
        return hospitalService.update(id, hospitalRequest);
    }

    @DeleteMapping("/api/hospital/{id}")
    public void delete(@PathVariable Long id){
        hospitalService.delete(id);
    }


}