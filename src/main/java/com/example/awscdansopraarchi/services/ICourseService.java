package com.example.awscdansopraarchi.services;

import com.example.awscdansopraarchi.dtos.CalculCourseDto;
import com.example.awscdansopraarchi.dtos.CourseDto;

public interface ICourseService {



    void addCourse(CalculCourseDto calculCourseDto);

    CourseDto getClientCourseStats(int clientId);
}
