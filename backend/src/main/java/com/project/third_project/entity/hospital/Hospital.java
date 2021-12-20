package com.project.third_project.entity.hospital;

import com.project.third_project.entity.BaseTimeEntity;
import com.project.third_project.entity.availableDate.AvailableDate;
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

    @OneToMany(mappedBy = "hospital")
    private List<Storage> storageList;

    @OneToOne(mappedBy = "hospital")
    private Reservation reservation;

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
