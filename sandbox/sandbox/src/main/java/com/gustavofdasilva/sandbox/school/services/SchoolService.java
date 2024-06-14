package com.gustavofdasilva.sandbox.school.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gustavofdasilva.sandbox.school.School;
import com.gustavofdasilva.sandbox.school.SchoolDTO;
import com.gustavofdasilva.sandbox.school.SchoolMapper;
import com.gustavofdasilva.sandbox.school.repositories.SchoolRepo;
import com.gustavofdasilva.sandbox.student.Student;
import com.gustavofdasilva.sandbox.student.StudentMapper;
import com.gustavofdasilva.sandbox.student.StudentResponseDTO;

@Service
public class SchoolService {
    private final StudentMapper studentMapper;
    private final SchoolMapper schoolMapper;
    private final SchoolRepo schoolRepo;

    public SchoolService(StudentMapper studentMapper, SchoolMapper schoolMapper, SchoolRepo schoolRepo) {
        this.studentMapper = studentMapper;
        this.schoolMapper = schoolMapper;
        this.schoolRepo = schoolRepo;
    }

    public SchoolDTO create(SchoolDTO school) {
        schoolRepo.save(schoolMapper.toSchool(school));

        return school;
    }

    public List<SchoolDTO> getAllSchools() {
        List<SchoolDTO> list = new ArrayList<>();
        for(School school: schoolRepo.findAll()) {
            list.add(schoolMapper.toSchoolDTO(school));
        }
        return list;
    }

    public List<StudentResponseDTO> getAllStudentsBySchool(String filter) {
        School school = schoolRepo.findByNameContaining(filter);
        List<StudentResponseDTO> res = new ArrayList<>();
        List<Student> students = school.getStudents();

        for(Student student : students) {
            res.add(studentMapper.toStudentRes(student));
        }

        return res;
    }
}
