//package com.example.demospringboot;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//// Component - allow IOC
//// Autowired - allow DI
//
//@RestController // Assume this is making APIs inside this class visible
//// to the embedded server so that it can route to an appropriate function
//public class SampleController {
//
//    // All the classes which have @Component annotation either directly or indirectly on top of it,
//    // spring will create an object of that class on application startup
//
//    // RestController --> Controller --> Component
//
//    private Logger logger = LoggerFactory.getLogger(SampleController.class);
//
////    @Autowired // tells spring not to create a new object, instead get the object from IOC container
////
////    Person person = new Person();
//
//    @Autowired // bean
//    Person person;
//
////    @Autowired
////    Person person2;
//
//    SampleController(){
//        this.logger.info("Inside SampleController constructor, object = {}", this);
//    }
//
//
//    @Value("${discount.percentage}") // bean
//    private Long discountPercentage;
//
//    @GetMapping("/hello")
//    public String sayHello(@RequestParam("n") String name){ // starting point for you to think on ioc
////        Person person = new Person();
//
//        int id = this.person.getRandomPersonId();
//        logger.info("person = {}, id = {}", this.person, id);
//
//        return "Hello " + name;
//    }
//
//    // com.example.demospringboot.Person@4362c1b9
//    // com.example.demospringboot.Person@4362c1b9
//    // com.example.demospringboot.Person@4362c1b9
//
////    @GetMapping("/hello2")
////    public String sayHello2(@RequestParam("n") String name){ // starting point for you to think on ioc
////        logger.info("Saying hello to {}", name);
////
////        // some operation which can throw an error
////        try{
////            int a = 1 / 0;
////            this.logger.info("Response: {}", a);
////        }catch (Exception e){
////            this.logger.error("sayHello2: Error while doing the operation: ", e);
////        }
////
////        return "Hello " + name;
////    }
//
//
//
//    /**
//     * Http methods available
//         * GET - even if you are inserting data in the get method it will still work
//         * PATCH
//         * PUT
//         * POST
//         * DELETE - even if you are retrieving data in delete, it will still work
//     * You should not use uppercase characters in your API path
//     * better to use hyphens instead of underscores in your API path
//
//        Data : {id: 1, name: ABC, age: 20}
//
//        PATCH - /person/{peronId}/
//              - data : {age: 10}
//              - Result - {id: 1, age: 10, name: ABC}
//              - update person set p.age = ? where id = ?
//
//        PUT - /person/{peronId}/
//            - data : {age: 10, name: ABC}
//            - Result - {id: 1, age: 10, name: ABC}
//
//            - update person set p.age = ? , p.name = ? where id = ?
//     */
//}
//
//
//// com.example.demospringboot.SampleController@6058e535 -- spring boot
//// com.example.demospringboot.SampleController@7c8fc29c -- created by me
//// com.example.demospringboot.SampleController@707b11e9 -- created by me