package com.project.third_project.entity.availableDate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {
    List<AvailableDate> findAllByHospitalId(Long hospitalId);
}
