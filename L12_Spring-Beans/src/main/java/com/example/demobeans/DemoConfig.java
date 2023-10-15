package com.example.demobeans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
//@Component
public class DemoConfig {

    private Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    @Bean(name = "template") // spring bean => invoked on application startup
    @Scope("singleton")
    public RestTemplate getTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        logger.info("Inside getTemplate: obj = {}", restTemplate);
        return restTemplate;
    }

    // RestTemplate@61e3a1fd
    // RestTemplate@7e425b21

//    @Bean
//    @Scope("prototype")
//    public DemoService getDemoService(){
//        return new DemoService();
//    }

    // obj1 = org.springframework.web.client.RestTemplate@4fb15da4
    // obj2 = org.springframework.web.client.RestTemplate@22a7c91a
    // obj3 = org.springframework.web.client.RestTemplate@7ff0f412

    // sampleController (name of the bean) ==> SampleController class object type
    // getTemplate (name of the bean) ==> RestTemplate class object type

}
