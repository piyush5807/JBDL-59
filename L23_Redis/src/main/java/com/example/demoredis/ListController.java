package com.example.demoredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListController {

    private static final String PERSON_LIST_KEY = "person_list";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/lpush")
    public void lpush(@RequestBody Person person){
        redisTemplate.opsForList().leftPush(PERSON_LIST_KEY, person);
    }

    @PostMapping("/rpush")
    public void rpush(@RequestBody Person person){
        redisTemplate.opsForList().rightPush(PERSON_LIST_KEY, person);
    }

    @DeleteMapping("/lpop")
    public List<Person> lpop(@RequestParam(value = "count", required = false, defaultValue = "1") int count){
        return redisTemplate.opsForList()
                .leftPop(PERSON_LIST_KEY, count)
                .stream()
                .map(o -> (Person)o)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/rpop")
    public List<Person> rpop(@RequestParam(value = "count", required = false, defaultValue = "1") int count){
        return redisTemplate.opsForList()
                .rightPop(PERSON_LIST_KEY, count)
                .stream()
                .map(o -> (Person)o)
                .collect(Collectors.toList());
    }


    @GetMapping("/lrange")
    public List<Person> lrange(@RequestParam(value = "start", required = false, defaultValue = "0") int start,
                               @RequestParam(value = "end", required = false, defaultValue = "-1") int end){

        return redisTemplate.opsForList()
                .range(PERSON_LIST_KEY, start, end)
                .stream()
                .map(o -> (Person)o)
                .collect(Collectors.toList());
    }



}
