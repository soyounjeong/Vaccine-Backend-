package com.project.third_project.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class HospitalRequest {
    private Long id;
    private String name;
    private String address;
    private String hp;
    private LocalDateTime createdAt;
}
