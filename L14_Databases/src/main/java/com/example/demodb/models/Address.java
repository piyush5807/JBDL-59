package com.example.demodb.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

    private String houseNo;

    private String streetName;

    private String city;

    private String state;

    private String country;

    private String pinCode;

    public static Address fromString(String address){
        // ...
        return new Address();
    }
}
