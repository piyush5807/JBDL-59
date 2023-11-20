package com.example.minorproject1.dto;

import lombok.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.constraints.NotBlank;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SearchBookRequest {

    @NotBlank
    private String searchKey;

    @NotBlank
    private String searchValue;

    @NotBlank
    private String operator;

    private boolean available;

    private static Set<String> allowedKeys = new HashSet<>();
    private static Map<String, List<String>> allowedOperatorsMap = new HashMap<>();

    SearchBookRequest(){
        allowedKeys.addAll(Arrays.asList("name", "author_name", "genre", "pages", "id"));

        allowedOperatorsMap.put("name", Arrays.asList("=", "like"));
        allowedOperatorsMap.put("author_name", Arrays.asList("="));
        allowedOperatorsMap.put("pages", Arrays.asList("<", "<=", ">", ">=", "="));
        allowedOperatorsMap.put("genre", Arrays.asList("="));
        allowedOperatorsMap.put("id", Arrays.asList("="));
    }


    public boolean validate(){

        if(!allowedKeys.contains(this.searchKey)){
            return false;
        }


        List<String> validOperators = allowedOperatorsMap.get(this.searchKey);
        if(!validOperators.contains(this.operator)){
            return false;
        }

        return true;
    }
}
