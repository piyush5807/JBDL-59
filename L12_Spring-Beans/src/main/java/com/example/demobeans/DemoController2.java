package com.example.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController2 {

    private Logger logger = LoggerFactory.getLogger(DemoController2.class);


    @Autowired
    RestTemplate restTemplate;

//    DemoController2(){
//        init();
//    }

//    public void init(){
//        restTemplate // define here
//    }

    @GetMapping("/test2")
    public String sayHello(){
        this.logger.info("test2, restTemplate - {}", restTemplate);
        return "Hello World2!!";
    }
}
