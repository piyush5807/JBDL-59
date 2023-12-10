package com.example.minorproject1.dto;

import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.SecuredUser;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse implements Serializable {

    private int id;
    private String name;
    private String contact;
    private Date createdOn;

    private Date updatedOn;
    private Date validity;

    public StudentResponse(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.contact = student.getContact();
        this.createdOn = student.getCreatedOn();
        this.updatedOn = student.getUpdatedOn();
        this.validity = student.getValidity();
    }
}
