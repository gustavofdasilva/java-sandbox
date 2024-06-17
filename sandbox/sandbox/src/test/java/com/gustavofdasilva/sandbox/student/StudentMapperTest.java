package com.gustavofdasilva.sandbox.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentMapperTest {

    private StudentMapper mapper = new StudentMapper();

    @Test
    public void shouldMapStudentDTOToStudent() {
        StudentDTO dto = new StudentDTO("John", "Smith","jonhsmith@mal.com",1);

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(),student.getFirstName());
        assertEquals(dto.lastName(),student.getLastName());
        assertEquals(dto.email(),student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.school_id(), student.getSchool().getId());
    }    

    @Test
    public void shouldMapStudentDTOtoStudentRes() {
        StudentDTO dto = new StudentDTO("John", "Smith","jonhsmith@mal.com",1);
        StudentResponseDTO StudentRes = mapper.toStudentRes(dto);

        assertEquals(dto.firstName(), StudentRes.firstName());
        assertEquals(dto.lastName(), StudentRes.lastName());
        assertEquals(dto.email(), StudentRes.email());
    }

    @Test
    public void shouldMapStudenttoStudentRes() {
        Student student = new Student("John", "Smith","jonhsmith@mal.com",1);
        StudentResponseDTO StudentRes = mapper.toStudentRes(student);

        assertEquals(student.getFirstName(), StudentRes.firstName());
        assertEquals(student.getLastName(), StudentRes.lastName());
        assertEquals(student.getEmail(), StudentRes.email());
    }
}
