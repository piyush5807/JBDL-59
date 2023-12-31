package com.example.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ImageController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@RequestParam("id") int id){
        String url = "https://picsum.photos/id/" + id + "/200/300";
        return restTemplate.getForEntity(url, byte[].class).getBody();

    }
}
