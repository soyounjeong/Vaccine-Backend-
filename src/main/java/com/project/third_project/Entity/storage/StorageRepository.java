package com.project.third_project.Entity.storage;

import com.project.third_project.Entity.vaccine.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<Storage, Long> {
}
