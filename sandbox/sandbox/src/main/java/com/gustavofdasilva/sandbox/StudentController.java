package com.gustavofdasilva.sandbox;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentRepo repo;
    
    public StudentController(StudentRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/helloworld")
    public String sayHello() {
        return "HELLO! from my first controller!";
    }

    @PostMapping("/student")
    public StudentResponseDTO postStudent(
        @RequestBody StudentDTO student
    ) {
        repo.save(toStudent(student));

        return toStudentRes(student);
    }
    
    private Student toStudent(StudentDTO dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.school_id());
        student.setSchool(school);
        return student;
    }

    private StudentResponseDTO toStudentRes(StudentDTO dto) {
        return new StudentResponseDTO(dto.firstName(), dto.lastName(), dto.email());
    }

    @GetMapping("/students") 
    public List<Student> getStudents() {
        return repo.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(
        @PathVariable("id") Integer id
    ) {
        return repo.findById(id).orElse(null);
    }

    @GetMapping("/students/{filter}")
    public List<Student> getAllStudentsByName(
        @PathVariable("filter") String filter
    ) {
        return repo.findAllByFirstNameContaining(filter);
    }
    

    @DeleteMapping("/student/{id}") 
    public String deleteStudentById(
        @PathVariable("id") Integer id
    ) {
        try {
            repo.deleteById(id);
            return "Student Deleted!";
        } catch (Exception e) {
            return "Couldn't find any student by this id...";
        }
    }

}
