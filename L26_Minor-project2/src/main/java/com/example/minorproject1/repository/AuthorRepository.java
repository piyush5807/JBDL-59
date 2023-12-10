package com.example.minorproject1.repository;

import com.example.minorproject1.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // select * from author where email = ?
    Author findByEmail(String email);
}
