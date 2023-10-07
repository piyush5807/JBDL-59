package com.example.demospringboot;

public class Test {

    int a;

    public static void func(){
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.func();
        Test.func();
    }
}
