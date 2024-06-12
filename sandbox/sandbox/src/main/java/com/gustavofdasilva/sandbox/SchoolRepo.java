package com.gustavofdasilva.sandbox;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<School, Integer>{
    School findByNameContaining(String p);
}
