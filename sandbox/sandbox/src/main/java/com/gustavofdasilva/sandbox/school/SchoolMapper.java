package com.gustavofdasilva.sandbox.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {
    public School toSchool(SchoolDTO dto) {
        School school = new School();
        school.setName(dto.name());

        return school;
    }

    public SchoolDTO toSchoolDTO(School school) {
        return new SchoolDTO(school.getName());
    }
}
