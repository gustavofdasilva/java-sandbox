package com.gustavofdasilva.sandbox.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepo repo;
    private final StudentMapper mapper;

    public StudentService(StudentRepo repo, StudentMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    
    public StudentResponseDTO postStudent(StudentDTO student) {
        repo.save(mapper.toStudent(student));
        return mapper.toStudentRes(student);
    }

    public List<StudentResponseDTO> getStudents() {
        List<Student> studentList = repo.findAll();
        List<StudentResponseDTO> dtoList = new ArrayList<>();

        for(Student s : studentList) {
            dtoList.add(mapper.toStudentRes(s));
        }

        return dtoList;
    }

    public StudentResponseDTO getStudentById(Integer id) {
        return mapper.toStudentRes(repo.findById(id).orElse(new Student()));
    }

    public List<StudentResponseDTO> getAllStudentsByName(String filter) {
        List<Student> filteredStudents = repo.findAllByFirstNameContaining(filter);
        List<StudentResponseDTO> dtoList = new ArrayList<>();

        for(Student s : filteredStudents) {
            dtoList.add(mapper.toStudentRes(s));
        }

        return dtoList;
    }

    public String deleteStudentById(Integer id) {
        try {
            repo.deleteById(id);
            return "Student Deleted!";
        } catch (Exception e) {
            return "Couldn't find any student by this id...";
        }
    }

}
