package com.project.third_project.entity.hospital;

import com.project.third_project.entity.BaseTimeEntity;
import com.project.third_project.entity.availableDate.AvailableDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Hospital extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 500)
    private String address;

    @Column(nullable = false)
    private String hp;


//    @OneToOne(mappedBy = "hospital")
//    private Reservation reservation;
    /* one to one 양방향 매핑에서 연관관계의 주인이 아닌곳에서 호출한다면 지연 로딩이 아닌 즉시 로딩이 동작
        why?
            프록시는 null을 감쌀 수 없기 때문에 참조하고 있는 객체가 null인지 null이 아닌지 확인하는 쿼리를 실행해야 하기 때문
     */

    @OneToMany(mappedBy = "hospital")
    private List<AvailableDate> availableDateList;

    @Builder
    public Hospital(String name, String address, String hp){
        this.name = name;
        this.address = address;
        this.hp = hp;
    }

    public void update(String name, String address, String hp){
        this.name = name;
        this.address = address;
        this.hp = hp;
    }

}
