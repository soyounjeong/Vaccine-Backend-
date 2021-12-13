package com.project.third_project.Entity.reservation;

import com.project.third_project.Entity.abailableTime.AvailableTime;
import com.project.third_project.Entity.availableDate.AvailableDate;
import com.project.third_project.Entity.hospital.Hospital;
import com.project.third_project.Entity.users.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private int usersId;

    @Column(nullable = false)
    private int hospitalId;

    @Column(nullable = false)
    private int availableDateId;

    @Column(nullable = false)
    private int availableTimeId;

    @OneToOne
    private Users users;

    @OneToOne
    private Hospital hospital;

    @OneToOne
    private AvailableDate availableDate;

    @OneToOne
    private AvailableTime availableTime;


}
