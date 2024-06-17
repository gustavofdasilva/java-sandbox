package com.gustavofdasilva.sandbox.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class StudentServiceTest {
    
    @Spy
    @InjectMocks
    private StudentMapper studentMapper;

    @Mock
    private StudentRepo repository;

    @Mock
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void shouldSucessfullySaveStudent() {
        StudentDTO dto = new StudentDTO("John", "Smith","jonhsmith@mal.com",1);
        Student student = new Student("John", "Smith","jonhsmith@mal.com",1);
        StudentResponseDTO studentRes = new StudentResponseDTO("John", "Smith","jonhsmith@mal.com");

        Mockito.when(repository.save(student)).thenReturn(student);
        Mockito.when(studentMapper.toStudentRes(student)).thenReturn(studentRes);
        Mockito.when(studentMapper.toStudent(dto)).thenReturn(student);

        StudentResponseDTO response = studentService.postStudent(dto);

        assertEquals(dto.firstName(), response.firstName());
        assertEquals(dto.lastName(), response.lastName());
        assertEquals(dto.email(), response.email());
    }
}
