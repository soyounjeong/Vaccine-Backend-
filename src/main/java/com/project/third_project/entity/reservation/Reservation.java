package com.project.third_project.entity.reservation;

import com.project.third_project.entity.abailableTime.AvailableTime;
import com.project.third_project.entity.availableDate.AvailableDate;
import com.project.third_project.entity.hospital.Hospital;
import com.project.third_project.entity.users.Users;
import lombok.Builder;
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

    @OneToOne
    private Users users;

    @OneToOne
    private Hospital hospital;

    @OneToOne
    private AvailableDate availableDate;

    @OneToOne
    private AvailableTime availableTime;


    @Builder
    public Reservation(Users users, Hospital hospital, AvailableDate availableDate, AvailableTime availableTime){
        this.users = users;
        this.hospital = hospital;
        this.availableDate = availableDate;
        this.availableTime = availableTime;
    }
}
