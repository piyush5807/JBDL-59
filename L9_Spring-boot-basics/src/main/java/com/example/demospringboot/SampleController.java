package com.example.demospringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Assume this is making APIs inside this class visible
// to the embedded server so that it can route to an appropriate function
public class SampleController {

    // define some apis that will do certain tasks,
    // basically the landing point of all requests from various clients

    // base url - 127.0.0.1:9000
    // api path - /sample , /hello
    // input -

    // ioc - inversion of control
    // di - dependency injection

    @GetMapping("/hello")
    public String sayHello(@RequestParam("n") String name){ // starting point for you to think on ioc
        return "Hello " + name;
    }

    /**
     * Http methods available
         * GET - even if you are inserting data in the get method it will still work
         * PATCH
         * PUT
         * POST
         * DELETE - even if you are retrieving data in delete, it will still work
     * You should not use uppercase characters in your API path
     * better to use hyphens instead of underscores in your API path

        Data : {id: 1, name: ABC, age: 20}

        PATCH - /person/{peronId}/
              - data : {age: 10}
              - Result - {id: 1, age: 10, name: ABC}
              - update person set p.age = ? where id = ?

        PUT - /person/{peronId}/
            - data : {age: 10, name: ABC}
            - Result - {id: 1, age: 10, name: ABC}

            - update person set p.age = ? , p.name = ? where id = ?
     */
}
