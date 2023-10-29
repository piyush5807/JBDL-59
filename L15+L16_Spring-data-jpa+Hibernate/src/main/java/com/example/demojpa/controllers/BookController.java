package com.example.demojpa.controllers;

import com.example.demojpa.dtos.CreateBookRequest;
import com.example.demojpa.models.Book;
import com.example.demojpa.models.BookCategory;
import com.example.demojpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/book") // @RequestMapping()
    public Book getBookById(@RequestParam("id") int id){
        return bookService.get(id);
    }

    @GetMapping("/all") // @RequestMapping()
    public List<Book> getBooks(){
        return bookService.get();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Book createBook(@RequestBody @Valid CreateBookRequest createBookRequest){
        return bookService.create(createBookRequest.to());
    }

    // Try to avoid camel cases and underscores in api path, instead use hyphens
    @GetMapping("/books-by-category")
    public List<Book> getBooksByCategory(@RequestParam("category") BookCategory category){
        return bookService.get(category);
    }
}
