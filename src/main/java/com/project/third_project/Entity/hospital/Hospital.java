package com.project.third_project.Entity.hospital;

import com.project.third_project.Entity.BaseTimeEntity;
import com.project.third_project.Entity.reservation.Reservation;
import com.project.third_project.Entity.storage.Storage;
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

    @OneToMany
    private List<Storage> storageList;

    @OneToOne(mappedBy = "hospital")
    private Reservation reservation;

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
