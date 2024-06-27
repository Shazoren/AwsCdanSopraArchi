package com.example.awscdansopraarchi.repositories;

import com.example.awscdansopraarchi.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
    List<CourseEntity> findByClientEntityId(int clientId);
}
