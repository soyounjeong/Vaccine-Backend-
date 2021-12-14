package com.project.third_project.Controller;

import com.project.third_project.Service.StorageService;
import com.project.third_project.dto.StorageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StorageApiController {
    private final StorageService storageService;

    @PostMapping("/api/storage/")
    public Long save(@RequestBody StorageRequest storageRequest){
        return storageService.save(storageRequest);
    }
}
