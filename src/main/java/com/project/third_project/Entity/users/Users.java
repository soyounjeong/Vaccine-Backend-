package com.project.third_project.Entity.users;

import com.project.third_project.Entity.BaseTimeEntity;
import com.project.third_project.Entity.reservation.Reservation;
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



}
