package com.project.third_project.Service;

import com.project.third_project.Entity.hospital.Hospital;
import com.project.third_project.Entity.hospital.HospitalRepository;
import com.project.third_project.Entity.storage.Storage;
import com.project.third_project.Entity.storage.StorageRepository;
import com.project.third_project.Entity.vaccine.Vaccine;
import com.project.third_project.Entity.vaccine.VaccineRepository;
import com.project.third_project.dto.StorageRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StorageServiceTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StorageRepository storageRepository;
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private VaccineRepository vaccineRepository;

    @AfterEach // 단위 테스트가 끝날때마다 수행되는 메소드
    public void delete() throws Exception{
        storageRepository.deleteAll();
    }

    @Test
    void save() throws Exception{

        Hospital hospital = hospitalRepository.save(Hospital.builder()
                .name("name")
                .address("address")
                .hp("hp")
                .build());
        Long updateId = hospital.getId();

        Vaccine vaccine = vaccineRepository.save(Vaccine.builder()
                        .name("name")
                        .region("region")
                        .expiration("expiration")
                .build());
        Long UpdateId = vaccine.getId();

        StorageRequest storageRequest = StorageRequest.builder()
                .hospitalId(updateId)
                .vaccineId(UpdateId)
                .build();
        String url = "http://localhost:" + port + "/api/storage";
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, storageRequest, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Storage> all = storageRepository.findAll();
        assertThat(all.get(0).getHospital().getId()).isEqualTo(updateId);
        assertThat(all.get(0).getVaccine().getId()).isEqualTo(UpdateId);

    }
}