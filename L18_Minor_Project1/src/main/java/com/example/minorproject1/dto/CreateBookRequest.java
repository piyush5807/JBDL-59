package com.example.minorproject1.dto;

import com.example.minorproject1.model.Author;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.enums.Genre;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookRequest {

    @NotBlank
    private String name; // book name

    @NotNull
    private Genre genre;

    private Integer pages;

    @NotBlank
    private String authorName;

    private String authorCountry;

    @NotBlank // not null + empty string
    private String authorEmail;

    public Book to() {
        return Book.builder()
                .name(this.name)
                .pages(this.pages)
                .genre(this.genre)
                .my_author(
                        Author.builder()
                                .name(this.authorName)
                                .country(this.authorCountry)
                                .email(this.authorEmail)
                                .build()
                )
                .build();
    }
}
