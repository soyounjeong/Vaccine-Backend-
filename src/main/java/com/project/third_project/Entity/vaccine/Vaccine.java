package com.project.third_project.Entity.vaccine;

import com.project.third_project.Entity.storage.Storage;
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

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private String expiration;

    @OneToMany(mappedBy = "vaccine")
    private List<Storage> storageList;

    @Builder
    public Vaccine(String name, String region, String expiration){
        this.name = name;
        this.region = region;
        this.expiration = expiration;
    }

    public void update(String name, String region, String expiration){
        this.name = name;
        this.region = region;
        this.expiration = expiration;
    }
}
