package com.example.awscdansopraarchi.ressources;

import com.example.awscdansopraarchi.dtos.InClientDto;
import com.example.awscdansopraarchi.entities.ClientEntity;
import com.example.awscdansopraarchi.enumation.typeClient;
import com.example.awscdansopraarchi.repositories.ChauffeurRepository;
import com.example.awscdansopraarchi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Client")
public class ClientController {

    @Autowired
    private ClientService service;
    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @PostMapping("add")
    public ResponseEntity add (@RequestBody InClientDto dto){

        // je dois controller mon dto

        try {
            typeClient.valueOf(dto.getType());
        }catch (Exception e) {
            return new ResponseEntity("type d'abonnement incorrect", HttpStatusCode.valueOf(400));
        }

        int id = service.ajouter(dto);
        return new ResponseEntity(id, HttpStatusCode.valueOf(200));
    }

    @GetMapping("get/{id}")
    public ResponseEntity get(@PathVariable String id) {

        Integer ID = Integer.parseInt(id);

        if(!service.exist(ID))
            return new ResponseEntity("Le client n'exsite pas", HttpStatusCode.valueOf(400));

        return new ResponseEntity(service.toDto(ID), HttpStatusCode.valueOf(200));

    }
    @GetMapping ("getAll")
    public ResponseEntity getAll (){
        return new  ResponseEntity(service.getAll(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        Integer ID = Integer.parseInt(id);

        if (!service.exist(ID)) {
            return new ResponseEntity("Le client n'existe pas", HttpStatusCode.valueOf(200));
        }

        service.delete(ID);
        return new ResponseEntity("Client supprimé avec succès", HttpStatusCode.valueOf(200));
    }
}
