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
public class Hospital extends BaseTimeEntity { // 클래스

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 필드 = 변수, 속성, 멤버변수

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

    /*
        생성자란?
        - 메소드와 비슷한 모양을 가지고 있으나, 리턴 타입이 없고 클래스 이름과 동일
     */
    @Builder
    public Hospital(String name, String address, String hp){ // 생성자
        this.name = name; // this 자기자신
        this.address = address;
        this.hp = hp;
    }

    /*
        메소드란?
        - 필드를 읽고 수정하는 역할도 하지만, 다른 객체를 생성해서 다양한 기능 수행 
     */

    public void update(String name, String address, String hp){ // 메소드
        this.name = name;// 왼쪽이 필드 오른쪽이 매개변수 => 필드 초기화
        this.address = address;
        this.hp = hp;
    }

}
