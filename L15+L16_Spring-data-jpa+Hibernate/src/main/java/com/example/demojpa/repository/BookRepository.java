package com.example.demojpa.repository;

import com.example.demojpa.models.Book;
import com.example.demojpa.models.BookCategory;
import com.example.demojpa.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer>{

    /**
     * 1. JPQL - Java Persistence Query Language
     *         - Format in which you write queries keeping Java objects into consideration
     *         - select b from Book b;
     *         - you need to query using an alias
     * 2. Native query
     *         - Format in which you write queries keeping relation / sql table into consideration just like the queries that you write on mysql shell
     *         - select * from book;
     *         - you can either use or ignore alias
     */

////    @Query("select b from Book b where b.bookCategory =:bc")
//    @Query("select b from Book b where b.bookCategory = ?1")
//    List<Book> findBooks(BookCategory bc);


    // Native query example
//    @Query(value = "select * from book b where b.bookcategory =:category", nativeQuery = true)
//    List<Book> findBooks(String category);

    //    @Query("select b from Book b where b.bookCategory =:bc")
//    @Query("select b from Book b where b.bookCategory = ?1")
//    @Query("select b from Book b where b.bookCategory =:bc")
    List<Book> findByBookCategoryAndLanguageAndPagesGreaterThan(BookCategory bc, Language language, int pages);
}
