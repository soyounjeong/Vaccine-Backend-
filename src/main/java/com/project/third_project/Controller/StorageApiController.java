package com.project.third_project.Controller;

import com.project.third_project.Service.StorageService;
import com.project.third_project.dto.StorageRequest;
import com.project.third_project.dto.StorageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StorageApiController {
    private final StorageService storageService;

    @PostMapping("/api/storage")
    public Long save(@RequestBody StorageRequest storageRequest){
        return storageService.save(storageRequest);
    }

    @GetMapping("/api/storage/{id}")
    public StorageResponse findById(@PathVariable Long id){
        return storageService.findById(id);
    }

    @PutMapping("/api/storage/{id}")
    public Long update(@PathVariable Long id, @RequestBody StorageRequest storageRequest){
        return storageService.update(id, storageRequest);
    }
}
