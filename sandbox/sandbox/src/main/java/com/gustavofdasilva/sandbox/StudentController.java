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
    
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/helloworld")
    public String sayHello() {
        return "HELLO! from my first controller!";
    }

    @PostMapping("/student")
    public StudentResponseDTO postStudent(
        @RequestBody StudentDTO student
    ) {
       return studentService.postStudent(student);
    }

    @GetMapping("/students") 
    public List<StudentResponseDTO> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO getStudentById(
        @PathVariable("id") Integer id
    ) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/{filter}")
    public List<StudentResponseDTO> getAllStudentsByName(
        @PathVariable("filter") String filter
    ) {
        return studentService.getAllStudentsByName(filter);
    }
    
    @DeleteMapping("/students/{id}") 
    public String deleteStudentById(
        @PathVariable("id") Integer id
    ) {
        return studentService.deleteStudentById(id);
    }

}
