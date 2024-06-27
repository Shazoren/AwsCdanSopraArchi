package com.example.awscdansopraarchi.services;

import com.example.awscdansopraarchi.dtos.InClientDto;
import com.example.awscdansopraarchi.dtos.OutClientDto;
import com.example.awscdansopraarchi.entities.ClientEntity;

import java.util.List;

public interface IClientService {
    Boolean exist(int ID);

    OutClientDto toDto(int id);

    Integer ajouter(InClientDto dto);

    ClientEntity toEntty(InClientDto dto);

    List<OutClientDto> getAll();

    ClientEntity get(int Id);

    void delete(int Id);
}
