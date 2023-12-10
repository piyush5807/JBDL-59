package com.example.minorproject1.service;

import com.example.minorproject1.model.Author;
import com.example.minorproject1.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author createOrGet(Author author){
        Author authorFromDB = this.authorRepository.findByEmail(author.getEmail());
        if(authorFromDB != null){
            return authorFromDB;
        }

        return this.authorRepository.save(author);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }
}
