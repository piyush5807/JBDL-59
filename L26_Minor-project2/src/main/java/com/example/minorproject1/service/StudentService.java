package com.example.minorproject1.service;

import com.example.minorproject1.dto.CreateStudentRequest;
import com.example.minorproject1.dto.StudentResponse;
import com.example.minorproject1.dto.UpdateStudentRequest;
import com.example.minorproject1.model.SecuredUser;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.repository.StudentCacheRepository;
import com.example.minorproject1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${student.authorities}")
    String authorities;

    @Autowired
    StudentCacheRepository studentCacheRepository;

    public Student create(CreateStudentRequest createStudentRequest){
        Student student = createStudentRequest.to();
        SecuredUser securedUser = student.getSecuredUser();
        securedUser.setPassword(passwordEncoder.encode(securedUser.getPassword()));
        securedUser.setAuthorities(authorities);

        // create a user
        securedUser = userService.save(securedUser);

        // create a student
        student.setSecuredUser(securedUser);
        return studentRepository.save(student);
    }

    public Student get(int studentId) {
        long start = System.currentTimeMillis();
        Student student = studentRepository.findById(studentId).orElse(null);
        long end = System.currentTimeMillis();
        System.out.println("Inside get function: Time taken to retrieve the data - " + (end - start));
        return student;
    }

    // you are just adding on the latency by increasing 1 redis call also
    public StudentResponse getUsingCache(int studentId) {
        long start = System.currentTimeMillis();
        StudentResponse studentResponse = studentCacheRepository.get(studentId); // 1 hour
        if(studentResponse == null){
            Student student = studentRepository.findById(studentId).orElse(null);
            studentResponse = new StudentResponse(student);
            long end = System.currentTimeMillis();
            System.out.println("Inside get function: Time taken to retrieve the data - " + (end - start));
            studentCacheRepository.set(studentResponse); // this call can be made in parallel
        }else{
            long end = System.currentTimeMillis();
            System.out.println("Inside get function: Time taken to retrieve the data - " + (end - start));

        }

        return studentResponse;
    }

    public Student delete(int studentId) {
        Student student = this.get(studentId);
        studentRepository.deleteById(studentId);
        return student;
    }

    public Student update(int studentId, UpdateStudentRequest updateStudentRequest){
        //TODO: Update as per your needs
        return null;
    }
}
