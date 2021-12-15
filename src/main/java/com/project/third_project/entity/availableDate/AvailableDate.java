package com.project.third_project.entity.availableDate;

import com.project.third_project.entity.abailableTime.AvailableTime;
import com.project.third_project.entity.hospital.Hospital;
import com.project.third_project.entity.reservation.Reservation;
import com.project.third_project.entity.storage.Storage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class AvailableDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Long quantity; //갯수?

    @OneToMany(mappedBy = "availableDate") // mappedBy : 주인 반대쪽에서 적는게 맞음
    private List<AvailableTime> availableTimeList; // 1대 다의 경우 List나 Set으로 받아올것!

    @OneToOne(mappedBy = "availableDate")
    private Reservation reservation;

    @ManyToOne
    private Hospital hospital;

    @ManyToOne
    private Storage storage;

    @Builder
    public AvailableDate(Hospital hospital, Storage storage, String date, Long quantity){
        this.hospital = hospital;
        this.storage = storage;
        this.date = date;
        this.quantity = quantity;
    }
}
