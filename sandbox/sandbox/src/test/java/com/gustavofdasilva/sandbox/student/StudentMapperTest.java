package com.gustavofdasilva.sandbox.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentMapperTest {

    @BeforeEach
    void setUp() {
        System.out.println("Before test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After test");
    }

    @Test
    public void testToStudent() {
        System.out.println("my first test");
    }
}
