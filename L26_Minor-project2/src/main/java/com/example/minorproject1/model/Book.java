package com.example.minorproject1.model;

import com.example.minorproject1.model.enums.Genre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book implements Serializable {

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
    @JsonIgnoreProperties({"bookList"}) // not a back reference
    private Author my_author; // M:1 from Book : Author

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"bookList"})
    private Student my_student; // M:1 from Book: Student

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"book"})
    List<Transaction> transactionList;

}
