package com.project.third_project.Service;

import com.project.third_project.Entity.hospital.Hospital;
import com.project.third_project.Entity.storage.StorageRepository;
import com.project.third_project.Entity.vaccine.VaccineRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StorageServiceTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StorageRepository storageRepository;

    @AfterEach // 단위 테스트가 끝날때마다 수행되는 메소드
    public void delete() throws Exception{
        storageRepository.deleteAll();
    }

    @Test
    void save() throws Exception{


    }
}