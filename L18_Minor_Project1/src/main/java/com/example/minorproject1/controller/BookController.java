package com.example.minorproject1.controller;

import com.example.minorproject1.dto.CreateBookRequest;
import com.example.minorproject1.dto.SearchBookRequest;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("")
    public Book createBook(@RequestBody @Valid CreateBookRequest createBookRequest){
        return bookService.create(createBookRequest);
    }

    @DeleteMapping("/{bookId}")
    public Book deleteBook(@PathVariable("bookId") int bookId){
        return bookService.delete(bookId);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.get();
    }

    // pages < 500
    // author_name , Peter =
    // name  'Programming101' =

    @GetMapping("/search")
    public List<Book> getBooksByAuthor(@RequestBody @Valid SearchBookRequest searchBookRequest) throws Exception {
        return bookService.search(searchBookRequest);
    }




}
