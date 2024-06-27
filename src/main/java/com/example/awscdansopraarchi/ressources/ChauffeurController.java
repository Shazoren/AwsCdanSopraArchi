package com.example.awscdansopraarchi.ressources;

import com.example.awscdansopraarchi.dtos.InChauffeurDto;
import com.example.awscdansopraarchi.dtos.InClientDto;
import com.example.awscdansopraarchi.enumation.typeChauffeur;
import com.example.awscdansopraarchi.enumation.typeClient;
import com.example.awscdansopraarchi.repositories.ChauffeurRepository;
import com.example.awscdansopraarchi.services.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("Chauffeur")
public class ChauffeurController {
    @Autowired
    private ChauffeurService service;

    @PostMapping("add")
    public ResponseEntity add (@RequestBody InChauffeurDto dto){

        try {
            typeChauffeur.valueOf(dto.getType());
        }catch (Exception e) {
            return new ResponseEntity("type de chauffeur incorrect", HttpStatusCode.valueOf(400));
        }

        int id = service.ajouter(dto);
        return new ResponseEntity(id, HttpStatusCode.valueOf(200));
    }

    @GetMapping("get/{id}")
    public ResponseEntity get(@PathVariable String id) {

        Integer ID = Integer.parseInt(id);

        if(!service.exist(ID))
            return new ResponseEntity("Le chauffeur n'exsite pas", HttpStatusCode.valueOf(400));

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
            return new ResponseEntity("Le chauffeur n'existe pas", HttpStatusCode.valueOf(200));
        }

        service.delete(ID);
        return new ResponseEntity("Chauffeur supprimé avec succès", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/countByType")
    public ResponseEntity<Map<String, Long>> countByType() {
        Map<String, Long> countByType = service.countChauffeursByType();
        return new ResponseEntity<>(countByType, HttpStatusCode.valueOf(200));
    }
}
