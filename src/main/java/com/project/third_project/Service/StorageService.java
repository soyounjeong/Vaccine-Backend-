package com.project.third_project.Service;


import com.project.third_project.Entity.storage.StorageRepository;
import com.project.third_project.dto.StorageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StorageService {
    private final StorageRepository storageRepository;

    @Transactional
    public Long save(StorageRequest storageRequest){
        return storageRepository.save(storageRequest.toEntity()).getId();
    }
}
