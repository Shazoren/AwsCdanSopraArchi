package com.example.awscdansopraarchi.services;

import com.example.awscdansopraarchi.dtos.InChauffeurDto;
import com.example.awscdansopraarchi.dtos.OutChauffeurDto;
import com.example.awscdansopraarchi.entities.ChauffeurEntity;


import java.util.List;
import java.util.Map;

public interface IChauffeurService {
    Boolean exist(int ID);

    OutChauffeurDto toDto(int id);

    OutChauffeurDto toDto(ChauffeurEntity entity);

    Integer ajouter(InChauffeurDto dto);

    ChauffeurEntity toEntty(InChauffeurDto dto);

    List<OutChauffeurDto> getAll();

    ChauffeurEntity get(int Id);

    void delete(int Id);

    Map<String, Long> countChauffeursByType();
}
