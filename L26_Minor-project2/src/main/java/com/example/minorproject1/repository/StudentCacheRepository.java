package com.example.minorproject1.repository;

import com.example.minorproject1.dto.StudentResponse;
import com.example.minorproject1.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class StudentCacheRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    private static final String STUDENT_KEY_PREFIX = "std::";

    public void set(StudentResponse student){
        System.out.println("Inside set function of cache repository");
        if(student.getId() == 0){
            return;
        }
        String key = STUDENT_KEY_PREFIX + student.getId();
        redisTemplate.opsForValue().set(key, student, 3600, TimeUnit.SECONDS);

    }

    public StudentResponse get(int studentId){
        System.out.println("Inside get function of cache repository");
        if(studentId == 0){
            return null;
        }
        String key = STUDENT_KEY_PREFIX + studentId;

        return (StudentResponse) redisTemplate.opsForValue().get(key);
    }
}
