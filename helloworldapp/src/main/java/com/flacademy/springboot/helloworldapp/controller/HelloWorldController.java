package com.flacademy.springboot.helloworldapp.controller;

import com.flacademy.springboot.helloworldapp.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/courses")
    public List<Course> getCourses() {
        Course course1 = new Course(1, "React", "Frontend Dev using React", 45);
        Course course2 = new Course(2, "Spring Boot", "Backend Dev using Java and Spring Boot", 60);
        Course course3 = new Course(3, "Web Design", "Web Design using HTML CSS and BootStrap", 45);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);

        return courses;

    }
}
