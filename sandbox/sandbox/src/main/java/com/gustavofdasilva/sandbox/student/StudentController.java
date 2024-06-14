package com.gustavofdasilva.sandbox.student;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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

    @PostMapping("/students")
    public StudentResponseDTO postStudent(
        @Valid @RequestBody StudentDTO student
    ) {
       return studentService.postStudent(student);
    }

    @GetMapping("/students") 
    public List<StudentResponseDTO> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/students/byId/{id}")
    public StudentResponseDTO getStudentById(
        @PathVariable("id") Integer id
    ) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/students/byName/{filter}")
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidExcepion(
        MethodArgumentNotValidException exception
    ){
        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
        .forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
