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

    @OneToOne
    private Users users;

    @OneToOne
    private Hospital hospital;

    @OneToOne
    private AvailableDate availableDate;

    @OneToOne
    private AvailableTime availableTime;


}
