package com.example.demospringboot;

public class Sample {

    int a = 10; // Step 1

//    @Value()
    int b;  // Step3

    Sample(){
        System.out.println(a); // Step 2
    }

    public static void main(String[] args) {
        Sample sample = new Sample();
    }
}
