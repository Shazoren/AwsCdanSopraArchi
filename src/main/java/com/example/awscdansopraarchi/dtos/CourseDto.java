package com.example.awscdansopraarchi.dtos;

public class CourseDto {

    private String client;
    private int nbCourse;
    private int distanceTotal;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public int getNbCourse() {
        return nbCourse;
    }

    public void setNbCourse(int nbCourse) {
        this.nbCourse = nbCourse;
    }

    public int getDistanceTotal() {
        return distanceTotal;
    }

    public void setDistanceTotal(int distanceTotal) {
        this.distanceTotal = distanceTotal;
    }
}
