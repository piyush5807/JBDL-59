package com.example.minorproject1.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    // One author can write multiple books
    //    1      :       N
    // Author           Book

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private Integer pages;

//    @ManyToMany
//    @ManyToOne
//    @OneToOne
//    @OneToMany
//
    // First part ~= Entity in which you are writing this annotation
    // Second part ~= Entity on top of which you are writing this annotation
    @ManyToOne
    @JoinColumn
    private Author my_author; // M:1 from Book : Author

    @ManyToOne
    @JoinColumn
    private Student my_student; // M:1 from Book: Student

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "my_book")
    List<Transaction> transactionList;

}
