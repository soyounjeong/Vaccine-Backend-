package com.project.third_project.service;

import com.project.third_project.entity.users.*;
import com.project.third_project.dto.UsersRequest;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsersServiceTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @AfterEach // 단위 테스트가 끝날때마다 수행되는 메소드
    public void delete() throws Exception{
        usersRepository.deleteAll();
    }

    @Test
    void save() throws Exception{
        String name = "프린세스 정영범";
        String pw = "1234";
        int age = 23;
        Gender gender = Gender.MAN;
        String address = "서울특별시 서초구";
        String addressDetail = "23길";
        String hp = "01033445757";
        Vaccination first = Vaccination.Y;
        Vaccination second = Vaccination.N;
        Role role = Role.USER;
        UsersRequest usersRequest = UsersRequest.builder()
                .name(name)
                .pw(pw)
                .age(age)
                .gender(gender)
                .address(address)
                .addressDetail(addressDetail)
                .hp(hp)
                .first(first)
                .second(second)
                .role(role)
                .build();
        String url = "http://localhost:" + port + "/api/users/";
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, usersRequest, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Users> all = usersRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getPw()).isEqualTo(pw);
        assertThat(all.get(0).getAge()).isEqualTo(age);
        assertThat(all.get(0).getGender()).isEqualTo(gender);
        assertThat(all.get(0).getAddress()).isEqualTo(address);
        assertThat(all.get(0).getAddressDetail()).isEqualTo(addressDetail);
        assertThat(all.get(0).getHp()).isEqualTo(hp);
        assertThat(all.get(0).getFirst()).isEqualTo(first);
        assertThat(all.get(0).getSecond()).isEqualTo(second);
        assertThat(all.get(0).getRole()).isEqualTo(role);
    }

    @Test
    void update() throws Exception{
        Users users = usersRepository.save(Users.builder()
                .name("name")
                .pw("pw")
                .gender(Gender.MAN)
                .age(10)
                .address("address")
                .addressDetail("addressDetail")
                .hp("hp")
                .first(Vaccination.Y)
                .second(Vaccination.N)
                .role(Role.USER)
                .build());
        Long updateId = users.getId();
        String Uname = "공주 영범";
        String Upw = "2323";
        Gender Ugender = Gender.WOMAN;
        int Uage = 34;
        String Uaddress = "경기도 분당구";
        String UaddressDetail = "10길";
        String Uhp = "01099998888";
        Vaccination Ufirst = Vaccination.N;
        Vaccination Usecond = Vaccination.N;
        Role Urole = Role.ADMIN;

        UsersRequest usersRequest = UsersRequest.builder()
                .name(Uname)
                .pw(Upw)
                .gender(Ugender)
                .age(Uage)
                .address(Uaddress)
                .addressDetail(UaddressDetail)
                .hp(Uhp)
                .first(Ufirst)
                .second(Usecond)
                .role(Urole)
                .build();
        String url = "http://localhost:" + port + "/api/users/" + updateId;

        HttpEntity<UsersRequest> usersRequestHttpEntity = new HttpEntity<>(usersRequest);
        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, usersRequestHttpEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Users> all = usersRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(Uname);
        assertThat(all.get(0).getPw()).isEqualTo(Upw);
        assertThat(all.get(0).getGender()).isEqualTo(Ugender);
        assertThat(all.get(0).getAge()).isEqualTo(Uage);
        assertThat(all.get(0).getAddress()).isEqualTo(Uaddress);
        assertThat(all.get(0).getAddressDetail()).isEqualTo(UaddressDetail);
        assertThat(all.get(0).getHp()).isEqualTo(Uhp);
        assertThat(all.get(0).getFirst()).isEqualTo(Ufirst);
        assertThat(all.get(0).getSecond()).isEqualTo(Usecond);
        assertThat(all.get(0).getRole()).isEqualTo(Urole);
    }

    @Test
    public void 삭제() throws  Exception{
        Users users = usersRepository.save(Users.builder()
                .name("name")
                .pw("pw")
                .gender(Gender.MAN)
                .age(10)
                .address("address")
                .addressDetail("addressDetail")
                .hp("hp")
                .first(Vaccination.Y)
                .second(Vaccination.N)
                .role(Role.USER)
                .build());
        Long Id = users.getId();

        String url = "http://localhost:" + port + "/api/users/" + Id;
        HttpEntity<Users> saveEntity = new HttpEntity<>(users);

        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, saveEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Users> deleted = usersRepository.findAll();
        assertThat(deleted).isEmpty();
    }
}