package com.project.third_project.Entity.abailableTime;

import com.project.third_project.Entity.availableDate.AvailableDate;
import com.project.third_project.Entity.reservation.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class AvailableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long availableDateId;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private  Long quantity;

    // ❗️fetch를 양쪽에 거는지 찾기❗ ️
    @ManyToOne(fetch = FetchType.EAGER)
    /*
        @ManyToOne, @OneToOne(fetch = FetchType.EAGER) "즉시 로딩"
        @oneToMany @ManyToMany(fetch = FetchType.Lazy) "지연 로딩"

        Lazy(지연로딩) : 사용할때 연관된 엔티티를 조회
        Earger(즉시로딩) : 한꺼번에 모든 걸 가져옴
    */
    private AvailableDate availableDate;

    @OneToOne(mappedBy = "availableTime")
    private Reservation reservation;
}
