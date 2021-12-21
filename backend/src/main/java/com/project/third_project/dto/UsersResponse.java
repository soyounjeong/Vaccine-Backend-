package com.project.third_project.dto;

import com.project.third_project.entity.users.Gender;
import com.project.third_project.entity.users.Role;
import com.project.third_project.entity.users.Users;
import com.project.third_project.entity.users.Vaccination;
import lombok.Getter;

@Getter
public class UsersResponse {
    private String email;
    private String name;
    private String pw;
    private Gender gender;
    private int age;
    private String address;
    private String addressDetail;
    private String hp;
    private Vaccination first;
    private Vaccination second;
    private Role role;

    public UsersResponse(Users users){
        this.email = users.getEmail();
        this.name = users.getName();
        this.pw = users.getPw();
        this.gender = users.getGender();
        this.age = users.getAge();
        this.address = users.getAddress();
        this.addressDetail = users.getAddressDetail();
        this.hp = users.getHp();
        this.first = users.getFirst();
        this.second = users.getSecond();
        this.role = users.getRole();
    }

}
