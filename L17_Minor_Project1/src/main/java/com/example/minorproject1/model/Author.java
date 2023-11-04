package com.example.minorproject1.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    @CreationTimestamp
    private Date addedOn;

    @OneToMany(mappedBy = "my_author") // You don't need to create a new column for bookList in the author table, just create a back-reference
    private List<Book> bookList;

    // GET Author details given an author id

    // select * from author where id = ? ==> id, name, country, addedOn
    // select * from book where author_id = ? ==> books


}
