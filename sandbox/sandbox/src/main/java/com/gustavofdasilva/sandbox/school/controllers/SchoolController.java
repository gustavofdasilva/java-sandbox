package com.gustavofdasilva.sandbox.school.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gustavofdasilva.sandbox.school.SchoolDTO;
import com.gustavofdasilva.sandbox.school.services.SchoolService;
import com.gustavofdasilva.sandbox.student.StudentResponseDTO;

@RestController
public class SchoolController {
    
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }   

    @PostMapping("/school")
    public SchoolDTO create(
        @RequestBody SchoolDTO school
    ) {
        return schoolService.create(school);
    }
    
    @GetMapping("/schools")
    public List<SchoolDTO> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/schools/{school}/students")
    public List<StudentResponseDTO> getAllStudentsBySchool(
        @PathVariable("school") String filter
    ) {
        return schoolService.getAllStudentsBySchool(filter);
    }

}
