package com.project.third_project.Entity.storage;

import com.project.third_project.Entity.hospital.Hospital;
import com.project.third_project.Entity.vaccine.Vaccine;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long hospitalId;

    @Column(nullable = false)
    private Long vaccineId;

    @Column(nullable = false)
    private  Long quantity;

    @OneToMany
    private List<Hospital> hospitalList;

    @ManyToOne
    private Vaccine vaccine;

    /*
        @ManyToOne(단방향) -> N:1
          - 한쪽 엔티티가 상대 엔티티를 참조하고 있는 상황
    */
}