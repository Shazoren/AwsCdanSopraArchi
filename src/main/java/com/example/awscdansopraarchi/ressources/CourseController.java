package com.example.awscdansopraarchi.ressources;

import com.example.awscdansopraarchi.dtos.CalculCourseDto;
import com.example.awscdansopraarchi.dtos.CourseDto;
import com.example.awscdansopraarchi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/add")
    public ResponseEntity<String> addCourse(@RequestBody CalculCourseDto calculCourseDto) {
        try {
            courseService.addCourse(calculCourseDto);
            return new ResponseEntity<>("Course added successfully", HttpStatusCode.valueOf(200));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(200));
        }
    }

    @GetMapping("/clientStats/{clientId}")
    public ResponseEntity<CourseDto> getClientCourseStats(@PathVariable int clientId) {
        CourseDto stats = courseService.getClientCourseStats(clientId);
        if (stats == null) {
            return new ResponseEntity ("Il n'existe pas de courses", HttpStatusCode.valueOf(200));
        }
        return new ResponseEntity (stats, HttpStatusCode.valueOf(200));
    }
}
