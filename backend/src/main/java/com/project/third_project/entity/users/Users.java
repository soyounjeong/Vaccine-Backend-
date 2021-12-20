package com.project.third_project.entity.users;

import com.project.third_project.entity.BaseTimeEntity;
import com.project.third_project.entity.reservation.Reservation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String name;

    @Column(nullable = false, length = 500)
    private String pw;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String addressDetail;

    @Column(nullable = false)
    private String hp;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Vaccination first;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Vaccination second;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToOne(mappedBy = "users")
    private Reservation reservation;

    @Builder
    public Users(String name, String pw, Gender gender, int age, String address, String addressDetail, String hp, Vaccination first, Vaccination second, Role role){
        this.name = name;
        this.pw = pw;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.addressDetail = addressDetail;
        this.hp = hp;
        this.first = first;
        this.second= second;
        this.role = role;
    }

    public void update(String name, String pw, Gender gender, int age, String address, String addressDetail, String hp, Vaccination first, Vaccination second, Role role){
        this.name = name;
        this.pw = pw;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.addressDetail = addressDetail;
        this.hp = hp;
        this.first = first;
        this.second= second;
        this.role = role;
    }

}
