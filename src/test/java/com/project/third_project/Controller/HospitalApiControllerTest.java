package com.project.third_project.Controller;

import com.project.third_project.Entity.hospital.Hospital;
import com.project.third_project.Entity.hospital.HospitalRepository;
import com.project.third_project.dto.HospitalRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;

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
}