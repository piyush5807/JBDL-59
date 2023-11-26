package com.example.demoredis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class HashController {

    /**
     * Value
     *      key - prefix+person_id  --> person (single item)
     * List
     *      key - constant /prefix   --> [person1, person2, ....] (list of items)
     * Hash
     *      key - prefix+person_id   --> {id: <value>, name: <value>, <field3>: <value3> .....}  (json item)
     *
     // person_hash::1   --> {"id": 1, "name": "ABC", "age": 30, ....}
     // person_hash::2   --> {"id": 2, "name": "DEF", "age": 40 .....}
     */

    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    private static final String PERSON_HASH_KEY_PREFIX = "person_hash::";

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/hmset")
    public void addPerson(@RequestBody Person person){

        Map map = objectMapper.convertValue(person, Map.class);
        redisTemplate.opsForHash().putAll(PERSON_HASH_KEY_PREFIX + person.getId(), map);
    }

    @GetMapping("/hgetall")
    public Person hgetall(@RequestParam("id") int personId){

        Map map = redisTemplate.opsForHash().entries(PERSON_HASH_KEY_PREFIX + personId);
        return objectMapper.convertValue(map, Person.class);
    }

    @DeleteMapping("/hdel")
    public Person hdel(@RequestParam("id") int id,
                       @RequestParam("attributes") String...fields){

        redisTemplate.opsForHash().delete(PERSON_HASH_KEY_PREFIX + id, fields);
        Map map = redisTemplate.opsForHash().entries(PERSON_HASH_KEY_PREFIX + id);
        return objectMapper.convertValue(map, Person.class);
    }
}
