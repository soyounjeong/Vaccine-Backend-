package com.project.third_project.entity.vaccine;

import com.project.third_project.entity.hospital.Hospital;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Vaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hospital hospital;

    @Column(nullable = false)
    private Long quantity;


    @Builder
    public Vaccine(String name, Hospital hospital, Long quantity){
        this.name = name;
        this.hospital = hospital;
        this.quantity = quantity;
    }

    public void update(String name, Hospital hospital, Long quantity){
        this.name = name;
        this.hospital = hospital;
        this.quantity = quantity;
    }

    public void minus1(Long quantity){
        this.quantity = quantity -1;
    }
}
