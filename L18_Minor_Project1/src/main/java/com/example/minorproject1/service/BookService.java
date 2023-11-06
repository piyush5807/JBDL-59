package com.example.minorproject1.service;

import com.example.minorproject1.dto.CreateBookRequest;
import com.example.minorproject1.dto.SearchBookRequest;
import com.example.minorproject1.model.Author;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.enums.Genre;
import com.example.minorproject1.repository.AuthorRepository;
import com.example.minorproject1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    // Book create function ==> 2 or 3
    public Book create(CreateBookRequest createBookRequest){

        Book book = createBookRequest.to(); // dto to model conversion
        Author author = authorService.createOrGet(book.getMy_author());

        book.setMy_author(author);
        return bookRepository.save(book);
    }

    public Book delete(int bookId) {
        Book book = this.bookRepository.findById(bookId).orElse(null);
        bookRepository.deleteById(bookId);
        return book;
    }

    public List<Book> search(SearchBookRequest searchBookRequest) throws Exception {
        boolean isValidRequest = searchBookRequest.validate();
        if(!isValidRequest){
            throw new Exception("Invalid Request");
        }

//        String sql = "select b from Book b where b.searchKey searchOperator searchValue";

        switch (searchBookRequest.getSearchKey()){
            case "name":
                return bookRepository.findByName(searchBookRequest.getSearchValue());
            case "genre":
                return bookRepository.findByGenre(Genre.valueOf(searchBookRequest.getSearchValue()));
            case "id": {
                Book book = bookRepository.findById(Integer.parseInt(searchBookRequest.getSearchValue())).orElse(null);
                return Arrays.asList(book);
            }

            default:
                throw new Exception("invalid search key");
        }


    }

    public List<Book> get() {
        return bookRepository.findAll();
    }

    // 1. An error will occur because of wrong foreign key mapping (author id == null)
    // 2. An error will occur but not because of null author id --  correct (Hibernate)
    // 3. book will be created but no author will be created
    // 4. both book and author will be created and mapped also accordingly
}
