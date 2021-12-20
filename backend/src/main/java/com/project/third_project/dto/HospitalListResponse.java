package com.project.third_project.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 리스트 뽑을때만 사용
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class HospitalListResponse {
    private String name;


}
