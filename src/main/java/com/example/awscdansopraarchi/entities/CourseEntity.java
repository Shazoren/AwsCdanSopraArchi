package com.example.awscdansopraarchi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_course")
    private String dateCourse;

    @Column(name = "temps_trajet")
    private Integer travelTime;

    @Column(name = "distance_course")
    private Integer distance;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_client")
    private ClientEntity clientEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chauffeur")
    private ChauffeurEntity chauffeurEntity;

    public ChauffeurEntity getChauffeurEntity() {
        return chauffeurEntity;
    }

    public void setChauffeurEntity(ChauffeurEntity chauffeurEntity) {
        this.chauffeurEntity = chauffeurEntity;
    }

    public ClientEntity getClientEntity() {
        return clientEntity;
    }

    public void setClientEntity(ClientEntity clientEntity) {
        this.clientEntity = clientEntity;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }

    public String getDateCourse() {
        return dateCourse;
    }

    public void setDateCourse(String dateCourse) {
        this.dateCourse = dateCourse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
