package com.gustavofdasilva.sandbox;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {

    private final SchoolRepo schoolRepo;

    public SchoolController(SchoolRepo schoolRepo) {
        this.schoolRepo = schoolRepo;
    }

    @PostMapping("/school")
    public SchoolDTO create(
        @RequestBody SchoolDTO school
    ) {
        schoolRepo.save(toSchool(school));

        return school;
    }

    
    @GetMapping("/schools")
    public List<SchoolDTO> getAllSchools() {
        List<SchoolDTO> list = new ArrayList<>();
        for(School school: schoolRepo.findAll()) {
            list.add(toSchoolDTO(school));
        }
        return list;
    }

    @GetMapping("/schools/{school}/students")
    public List<StudentResponseDTO> getAllStudentsBySchool(
        @PathVariable("school") String filter
    ) {
        School school = schoolRepo.findByNameContaining(filter);
        List<StudentResponseDTO> res = new ArrayList<>();
        List<Student> students = school.getStudents();

        for(Student student : students) {
            res.add(toStudentRes(student));
        }

        return res;
    }

    private StudentResponseDTO toStudentRes(Student student) {
        return new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }

    private School toSchool(SchoolDTO dto) {
        School school = new School();
        school.setName(dto.name());

        return school;
    }

    private SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }
}
