package com.gustavofdasilva.sandbox;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepo extends JpaRepository<Student, Integer>{
    
    List<Student> findAllByFirstNameContaining(String p);
}
