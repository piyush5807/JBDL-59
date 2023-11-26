package com.example.demoredis;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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

    private List<String> children;
    private Map<String, Object> properties;

}
