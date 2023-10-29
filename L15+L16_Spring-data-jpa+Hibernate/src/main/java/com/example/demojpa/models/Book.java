package com.example.demojpa.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    // GenerationStrategy - AUTO (Hibernate will be generating the id for your record and then that
    //                      id is passed to the underlying db)

    // GenerationStrategy - IDENTITY (Underlying db will generate an id for your record)


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // hibernate will be generating id for us
    private int id;
    private String name;
    private String authorName;
    private String publisherName;

    @Column(name = "book_pages")
    private int pages;

    @Enumerated(value = EnumType.STRING)
    private BookCategory bookCategory;
    @Enumerated()
    private Language language;
    @CreationTimestamp
    private Date createdOn; // insert into
    @UpdateTimestamp
    private Date updatedOn; // insert into / update / delete

}
