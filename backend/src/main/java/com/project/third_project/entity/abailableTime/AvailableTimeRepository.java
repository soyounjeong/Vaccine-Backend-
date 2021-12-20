package com.project.third_project.entity.abailableTime;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvailableTimeRepository extends JpaRepository<AvailableTime, Long> {
    List<AvailableTime> findAllByAvailableDateId(Long hospitalId);
}
