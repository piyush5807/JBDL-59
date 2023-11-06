package com.example.minorproject1.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    // S1 --> B1 FOR 10 DAYS
    // S1 --> B2 FOR 15 DAYS

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String contact;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "my_student")
    @JsonIgnoreProperties({"my_student"})
    private List<Book> bookList;

    @OneToMany(mappedBy = "my_student")
    @JsonIgnoreProperties({"my_student"})
    List<Transaction> transactionList;

    private Date validity;

}
