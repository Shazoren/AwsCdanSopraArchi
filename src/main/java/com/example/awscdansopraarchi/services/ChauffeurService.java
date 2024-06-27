package com.example.awscdansopraarchi.services;

import com.example.awscdansopraarchi.dtos.InChauffeurDto;
import com.example.awscdansopraarchi.dtos.OutChauffeurDto;
import com.example.awscdansopraarchi.entities.ChauffeurEntity;
import com.example.awscdansopraarchi.repositories.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChauffeurService implements IChauffeurService{

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Override
    public Boolean exist(int ID) {
        return chauffeurRepository.existsById(ID);
    }

    @Override
    public OutChauffeurDto toDto(ChauffeurEntity entity) {
        OutChauffeurDto result = new OutChauffeurDto();
        result.setNom(entity.getName());
        result.setPrenom(entity.getFirstname());
        result.setBirth(entity.getBirth());
        result.setInscription(entity.getInscription());
        result.setType(entity.getType());
        return result;
    }

    @Override
    public OutChauffeurDto toDto(int id) {
        if (!exist(id))
            return null;
        // sinon
        ChauffeurEntity entity = chauffeurRepository.findById(id).get();
        OutChauffeurDto result = new OutChauffeurDto();
        result.setNom(entity.getName());
        result.setPrenom(entity.getFirstname());
        result.setBirth(entity.getBirth());
        result.setInscription(entity.getInscription());
        result.setType(entity.getType());
        return result;
    }

    @Override
    public Integer ajouter(InChauffeurDto dto) {
        ChauffeurEntity entity = toEntty(dto);
        chauffeurRepository.saveAndFlush(entity);

        return entity.getId();
    }

    @Override
    public ChauffeurEntity toEntty(InChauffeurDto dto) {
        ChauffeurEntity entity = new ChauffeurEntity();
        entity.setName(dto.getNom());
        entity.setFirstname(dto.getPrenom());
        entity.setBirth(dto.getBirth());
        entity.setInscription(dto.getInscription());
        entity.setType(dto.getType());

        return entity;
    }

    @Override
    public List<OutChauffeurDto> getAll() {
        return chauffeurRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ChauffeurEntity get(int Id) {
        return chauffeurRepository.findById(Id).get();
    }

    @Override
    public void delete(int Id) {
        chauffeurRepository.deleteById(Id);
    }

    @Override
    public Map<String, Long> countChauffeursByType() {
        List<ChauffeurEntity> chauffeurs = chauffeurRepository.findAll();
        return chauffeurs.stream()
                .collect(Collectors.groupingBy(ChauffeurEntity::getType, Collectors.counting()));
    }
}
