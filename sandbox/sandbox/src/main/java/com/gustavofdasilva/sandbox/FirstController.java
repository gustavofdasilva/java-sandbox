package com.gustavofdasilva.sandbox;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    private final StudentRepo repo;
    
    public FirstController(StudentRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/helloworld")
    public String sayHello() {
        Student student = new Student();
        return "HELLO! from my first controller!";
    }

    @PostMapping("/postStudent")
    public Student postStudent(
        @RequestBody Student student
    ) {
        return repo.save(student);
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
