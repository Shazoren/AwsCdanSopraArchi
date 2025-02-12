package com.example.awscdansopraarchi.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Chauffeurs")
public class ChauffeurEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String name;

    @Column(name = "prenom")
    private String firstname;

    @Column(name = "date_naissance")
    private LocalDate birth;

    @Column(name = "date_inscription")
    private LocalDate inscription;

    @Column(name = "type_chauffeur")
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getInscription() {
        return inscription;
    }

    public void setInscription(LocalDate inscription) {
        this.inscription = inscription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
