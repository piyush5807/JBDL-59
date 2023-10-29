package com.example.demojpa.services;

import com.example.demojpa.models.Book;
import com.example.demojpa.models.BookCategory;
import com.example.demojpa.models.Language;
import com.example.demojpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book create(Book book){
        // convert here itself from request --> model
        book.setId(5); // useless if we are using generationType.IDENTITY
        return bookRepository.save(book); // insert into book () VALUES ()
    }

    public Book get(int id) {
        return bookRepository.findById(id).orElse(null); // select * from book where id = ?
    }

    public List<Book> get() {
        return bookRepository.findAll(); // select * from book;
    }

    public List<Book> get(BookCategory bookCategory){
        return bookRepository.findByBookCategoryAndLanguageAndPagesGreaterThan(bookCategory, Language.ENGLISH, 40);
    }
}
