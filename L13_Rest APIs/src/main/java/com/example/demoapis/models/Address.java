package com.example.demoapis.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String houseNo;

    private String streetName;

    private String city;

    private String state;

    private String country;

    private String pinCode;
}
