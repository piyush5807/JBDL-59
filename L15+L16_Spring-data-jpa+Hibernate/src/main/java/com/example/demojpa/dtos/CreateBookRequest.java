package com.example.demojpa.dtos;

import com.example.demojpa.models.Book;
import com.example.demojpa.models.BookCategory;
import com.example.demojpa.models.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class CreateBookRequest {


    @NotBlank
    private String name;

    private String authorName;
    private String publisherName;
    private int pages;

    private BookCategory bookCategory;
    private Language language;

    public Book to(){
        return Book.builder()
                .name(this.name)
                .authorName(this.authorName)
                .publisherName(this.publisherName)
                .bookCategory(this.bookCategory)
                .language(this.language)
                .pages(this.pages)
                .build();
    }

}
