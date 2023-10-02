package org.example;

public class Calci {

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static int add(int a, int b){
        return a + b;
    }

    public static int subtract(int a, int b){
        return Math.abs(a - b);
    }

    public static int multiply(int a, int b){
        return a * b;
    }

    public static int divide(int a, int b){
        return a / b;
    }
}