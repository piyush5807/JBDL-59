package com.example.demoredis;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {

    private Integer id;
    private String name;
    private Long age;
    private Boolean isNRI;
    private Double creditScore;
}
