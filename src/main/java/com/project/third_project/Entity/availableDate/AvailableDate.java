package com.project.third_project.Entity.availableDate;

import com.project.third_project.Entity.abailableTime.AvailableTime;
import com.project.third_project.Entity.reservation.Reservation;
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
    private Long hospitalId;

    @Column(nullable = false)
    private Long storageId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private Long quantity;

    @OneToMany(mappedBy = "availableDate") // mappedBy : 주인 반대쪽에서 적는게 맞음
    private List<AvailableTime> availableTimeList; // 1대 다의 경우 List나 Set으로 받아올것!

    @OneToOne(mappedBy = "availableDate")
    private Reservation reservation;
}
