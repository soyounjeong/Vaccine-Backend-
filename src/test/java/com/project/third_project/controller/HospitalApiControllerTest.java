package com.project.third_project.controller;

import com.project.third_project.entity.hospital.Hospital;
import com.project.third_project.entity.hospital.HospitalRepository;
import com.project.third_project.dto.HospitalRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HospitalApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HospitalRepository hospitalRepository;

    @AfterEach // 단위 테스트가 끝날때마다 수행되는 메소드
    public void delete() throws Exception{
        hospitalRepository.deleteAll();
    }

    @Test
    void save() throws Exception{
        String name = "정영범";
        String address = "동작구";
        String hp = "01011111111";
        HospitalRequest hospitalRequest = HospitalRequest.builder()
                .name(name)
                .address(address)
                .hp(hp)
                .build();
        String url = "http://localhost:" + port + "/api/hospital";
        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, hospitalRequest, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Hospital> all = hospitalRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getAddress()).isEqualTo(address);
        assertThat(all.get(0).getHp()).isEqualTo(hp);
    }

    @Test
    void update() throws Exception{
        Hospital savehospital = hospitalRepository.save(Hospital.builder()
                .address("address")
                .hp("hp")
                .name("name")
                .build());

        Long updateId = savehospital.getId();
        String Updateaddress = "서초구";
        String Updatehp = "01099999999";
        String Updatename = "공주";

        HospitalRequest hospitalRequest = HospitalRequest.builder()
                .address(Updateaddress)
                .hp(Updatehp)
                .name(Updatename)
                .build();
        String url = "http://localhost:" + port + "/api/hospital/" + updateId;

        HttpEntity<HospitalRequest> hospitalRequestHttpEntity = new HttpEntity<>(hospitalRequest);
        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, hospitalRequestHttpEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Hospital> all = hospitalRepository.findAll();
        assertThat(all.get(0).getAddress()).isEqualTo(Updateaddress);
        assertThat(all.get(0).getHp()).isEqualTo(Updatehp);
        assertThat(all.get(0).getName()).isEqualTo(Updatename);
    }

    @Test
    public void 삭제() throws Exception{
        Hospital savehospital = hospitalRepository.save(Hospital.builder()
                .address("address")
                .hp("hp")
                .name("name")
                .build());
        Long Id = savehospital.getId();

        String url = "http://localhost:" + port + "/api/hospital/" + Id;
        HttpEntity<Hospital> saveEntity = new HttpEntity<>(savehospital);
        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, saveEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Hospital> deleted = hospitalRepository.findAll();
        assertThat(deleted).isEmpty();
    }
}