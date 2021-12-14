package com.project.third_project.Controller;

import com.project.third_project.Service.VaccineService;
import com.project.third_project.dto.VaccineResponse;
import com.project.third_project.dto.VaccineResquest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class VaccineApiController {
    private final VaccineService vaccineService;

    @GetMapping("/api/vaccine/{id}")
    public VaccineResponse findById(@PathVariable Long id){
        return vaccineService.findById(id);
    }

    @PostMapping("/api/vaccine/")
    public Long save(@RequestBody VaccineResquest vaccineResquest){
        return vaccineService.save(vaccineResquest);
    }

    @PutMapping("/api/vaccine/{id}")
    public Long update(@PathVariable Long id, @RequestBody VaccineResquest vaccineResquest){
        return vaccineService.update(id, vaccineResquest);
    }

    @DeleteMapping("/api/vaccine/{id}")
    public void delete(@PathVariable Long id){
        vaccineService.delete(id);
    }

}
