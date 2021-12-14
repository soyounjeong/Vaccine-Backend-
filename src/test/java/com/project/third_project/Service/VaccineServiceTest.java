package com.project.third_project.Service;

import com.project.third_project.Entity.hospital.HospitalRepository;
import com.project.third_project.Entity.users.Users;
import com.project.third_project.Entity.vaccine.Vaccine;
import com.project.third_project.Entity.vaccine.VaccineRepository;
import com.project.third_project.dto.UsersRequest;
import com.project.third_project.dto.VaccineResquest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VaccineServiceTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private VaccineRepository vaccineRepository;

    @AfterEach // 단위 테스트가 끝날때마다 수행되는 메소드
    public void delete() throws Exception{
       vaccineRepository.deleteAll();
    }

    @Test
    void findById() {
    }

    @Test
    void save() throws Exception{
        String name = "모더나";
        String region = "미국";
        String expiration = "20230331";
        VaccineResquest vaccineResquest = VaccineResquest.builder()
                .name(name)
                .region(region)
                .expiration(expiration)
                .build();
        String url = "http://localhost:" + port + "/api/vaccine/";
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, vaccineResquest, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Vaccine> all = vaccineRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getRegion()).isEqualTo(region);
        assertThat(all.get(0).getExpiration()).isEqualTo(expiration);
    }

    @Test
    void update() throws Exception{
        Vaccine vaccine = vaccineRepository.save(Vaccine.builder()
                        .name("name")
                        .region("region")
                        .expiration("expiration")
                .build());
        Long updateId = vaccine.getId();
        String Uname = "화이자";
        String Uregion = "영국";
        String Uexpiration = "20240303";

        VaccineResquest vaccineResquest = VaccineResquest.builder()
                .name(Uname)
                .region(Uregion)
                .expiration(Uexpiration)
                .build();
        String url = "http://localhost:" + port + "/api/vaccine/" + updateId;

        HttpEntity<VaccineResquest> vaccineRequestHttpEntity = new HttpEntity<>(vaccineResquest);
        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, vaccineRequestHttpEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Vaccine> all = vaccineRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(Uname);
        assertThat(all.get(0).getRegion()).isEqualTo(Uregion);
        assertThat(all.get(0).getExpiration()).isEqualTo(Uexpiration);
    }

    @Test
    public void 삭제() throws  Exception{
        Vaccine vaccine = vaccineRepository.save(Vaccine.builder()
                        .name("name")
                        .region("region")
                        .expiration("expiration")
                .build());
        Long Id = vaccine.getId();
        String url = "http://localhost:" + port + "/api/vaccine/" + Id;
        HttpEntity<Vaccine> saveEntity = new HttpEntity<>(vaccine);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, saveEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Vaccine> deleted = vaccineRepository.findAll();
        assertThat(deleted).isEmpty();
    }
}