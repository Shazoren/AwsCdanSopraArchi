package com.example.awscdansopraarchi.services;

import com.example.awscdansopraarchi.dtos.InClientDto;
import com.example.awscdansopraarchi.dtos.OutClientDto;
import com.example.awscdansopraarchi.entities.ClientEntity;
import com.example.awscdansopraarchi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Boolean exist(int ID) {
        return clientRepository.existsById(ID);
    }

    public OutClientDto toDto(ClientEntity entity){

        OutClientDto result = new OutClientDto();
        result.setNom(entity.getName());
        result.setPrenom(entity.getFirstname());
        result.setBirth(entity.getBirth());
        result.setInscription(entity.getInscription());
        result.setType(entity.getType());
        return result;
    }

    @Override
    public OutClientDto toDto(int id) {
        if (!exist(id))
            return null;
        // sinon
        ClientEntity entity = clientRepository.findById(id).get();
        OutClientDto result = new OutClientDto();
        result.setNom(entity.getName());
        result.setPrenom(entity.getFirstname());
        result.setBirth(entity.getBirth());
        result.setInscription(entity.getInscription());
        result.setType(entity.getType());
        return result;
    }

    @Override
    public Integer ajouter(InClientDto dto) {

        ClientEntity entity = toEntty(dto);
        clientRepository.saveAndFlush(entity);

        return entity.getId();
    }

    @Override
    public ClientEntity toEntty(InClientDto dto) {
        ClientEntity entity = new ClientEntity();
        entity.setName(dto.getNom());
        entity.setFirstname(dto.getPrenom());
        entity.setBirth(dto.getBirth());
        entity.setInscription(dto.getInscription());
        entity.setType(dto.getType());

        return entity;
    }

    @Override
    public List<OutClientDto> getAll() {
        return clientRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public ClientEntity get(int Id) {
        return clientRepository.findById(Id).get();
    }

    @Override
    public void delete(int Id) {
        clientRepository.deleteById(Id);
    }
}
