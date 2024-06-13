package com.gustavofdasilva.sandbox;

import org.springframework.stereotype.Service;

import com.gustavofdasilva.sandbox.school.School;

@Service
public class StudentMapper {
    public Student toStudent(StudentDTO dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.school_id());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDTO toStudentRes(StudentDTO dto) {
        return new StudentResponseDTO(dto.firstName(), dto.lastName(), dto.email());
    }

    public StudentResponseDTO toStudentRes(Student student) {
        return new StudentResponseDTO(student.getFirstName(), student.getLastName(), student.getEmail());
    }
}
