package com.gustavofdasilva.sandbox.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavofdasilva.sandbox.school.School;

public interface SchoolRepo extends JpaRepository<School, Integer>{
    School findByNameContaining(String p);
}
