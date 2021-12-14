package com.project.third_project.dto;

import com.project.third_project.Entity.users.Gender;
import com.project.third_project.Entity.users.Role;
import com.project.third_project.Entity.users.Users;
import com.project.third_project.Entity.users.Vaccination;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsersRequest {
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

    @Builder
    public UsersRequest(String name, String pw, Gender gender, int age, String address, String addressDetail, String hp, Vaccination first, Vaccination second, Role role){
        this.name = name;
        this.pw = pw;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.addressDetail = addressDetail;
        this.hp = hp;
        this.first = first;
        this.second = second;
        this.role = role;
    }

    public Users toEntity(){
        return Users.builder()
                .name(name)
                .pw(pw)
                .gender(gender)
                .age(age)
                .address(address)
                .addressDetail(addressDetail)
                .hp(hp)
                .first(first)
                .second(second)
                .role(role)
                .build();
    }
}
