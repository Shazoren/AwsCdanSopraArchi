package com.example.awscdansopraarchi.repositories;

import com.example.awscdansopraarchi.entities.ChauffeurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChauffeurRepository extends JpaRepository<ChauffeurEntity, Integer> {
}
