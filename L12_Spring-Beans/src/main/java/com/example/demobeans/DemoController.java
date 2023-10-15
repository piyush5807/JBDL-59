package com.example.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController // telling spring-boot to create a bean by adding the annotation at the class level
public class DemoController {

    // function level annotation for creating beans

    private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    DemoConfig demoConfig; // field Dependency injection

//    @Autowired
//    DemoService demoService;

//    @Autowired
////    @Qualifier("template") // use this only when there are more than 1 bean of type restTemplate
//    RestTemplate restTemplate;



    @GetMapping("/test")
    public String sayHello(){
        RestTemplate restTemplate = demoConfig.getTemplate(); // no NPE
        this.logger.info("restTemplate = {}", restTemplate);
        return "Hello World!!";
    }
}


// org.springframework.web.client.RestTemplate@1556f2dd
// org.springframework.web.client.RestTemplate@1556f2dd
//