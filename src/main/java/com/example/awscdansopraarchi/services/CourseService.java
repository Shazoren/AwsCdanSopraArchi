package com.example.awscdansopraarchi.services;

import com.example.awscdansopraarchi.dtos.CalculCourseDto;
import com.example.awscdansopraarchi.dtos.CourseDto;
import com.example.awscdansopraarchi.entities.ChauffeurEntity;
import com.example.awscdansopraarchi.entities.ClientEntity;
import com.example.awscdansopraarchi.entities.CourseEntity;
import com.example.awscdansopraarchi.repositories.ChauffeurRepository;
import com.example.awscdansopraarchi.repositories.ClientRepository;
import com.example.awscdansopraarchi.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Override
    public void addCourse(CalculCourseDto calculCourseDto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setDateCourse(calculCourseDto.getDateCourse());
        courseEntity.setTravelTime(calculCourseDto.getTravelTime());
        courseEntity.setDistance(calculCourseDto.getDistance());

        Optional<ClientEntity> clientEntityOpt = clientRepository.findById(calculCourseDto.getClientId());
        if (clientEntityOpt.isEmpty()) {
            throw new IllegalArgumentException("Client not found");
        }
        courseEntity.setClientEntity(clientEntityOpt.get());


        Optional<ChauffeurEntity> chauffeurEntityOpt = chauffeurRepository.findById(calculCourseDto.getChauffeurId());
        if (chauffeurEntityOpt.isEmpty()) {
            throw new IllegalArgumentException("Chauffeur not found");
        }
        courseEntity.setChauffeurEntity(chauffeurEntityOpt.get());

        courseRepository.save(courseEntity);
    }

    @Override
    public CourseDto getClientCourseStats(int clientId) {
        List<CourseEntity> courses = courseRepository.findByClientEntityId(clientId);
        if (courses.isEmpty()) {
            return null;
        }

        ClientEntity client = courses.get(0).getClientEntity();
        String clientName = client.getFirstname() + " " + client.getName();

        int nbCourse = courses.size();
        int distanceTotal = courses.stream().mapToInt(CourseEntity::getDistance).sum();

        CourseDto stats = new CourseDto();
        stats.setClient(clientName);
        stats.setNbCourse(nbCourse);
        stats.setDistanceTotal(distanceTotal);

        return stats;
    }
}
