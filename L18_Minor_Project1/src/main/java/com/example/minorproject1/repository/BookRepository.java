package com.example.minorproject1.repository;

import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.enums.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    public List<Book> findByName(String name);

    List<Book> findByGenre(Genre genre);

}
