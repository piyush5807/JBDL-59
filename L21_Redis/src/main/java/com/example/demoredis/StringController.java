package com.example.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
public class StringController {

    private static String PERSON_VALUE_PREFIX = "person::";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/set/{personId}")
    public void setValue(@PathVariable("personId") Integer personId,
                         @RequestBody Person person){

        String key = PERSON_VALUE_PREFIX + personId;
        redisTemplate.opsForValue().set(key, person, 60, TimeUnit.MINUTES);
    }

    @GetMapping("/get/{personId}")
    public Person getValue(@PathVariable("personId") Integer personId){
        String key = PERSON_VALUE_PREFIX + personId;
       return (Person) redisTemplate.opsForValue().get(key);
    }
}
