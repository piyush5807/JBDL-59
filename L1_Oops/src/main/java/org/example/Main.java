package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello world!");
//
//        Person p = new Person();
//        p.setName("Shyam");
////        p.age = -2;
//
//        int a = 9;
//        int b = 10;
//
//        plus(a, b);
//
//        String s1 = "abc";
//        String s2 = "def";
//
//        plus(s1, s2);
//
//        {
//            @Override
//            public int add(int a, int b) {
//                return 0;
//            }
//
////            @Override
////            public int subtract(int a, int b) {
////                return 0;
////            }
//
////            @Override
////            public int multiply(int a, int b) {
////                return SampleInterface.super.multiply(a, b);
////            }
//        };

//        sampleInterface.multiply(10, 20);
//        sampleInterface.add(10, 30);

//        SampleInterface sampleInterface = new SampleInterface() {
//            @Override
//            public int subtract(int a, int b) {
//                return a - b;
//            }
//        };
//        System.out.println(sampleInterface.add(10, 20));
//        System.out.println(sampleInterface.subtract(10, 20));

        SampleInterfaceImp sampleInterfaceImp = new SampleInterfaceImp();
        sampleInterfaceImp.subtract(10, 20);
    }

    public static void plus(int a, int b){
        System.out.println(a + b);
    }

    public static int plus(String a, String b){
        System.out.println(a + b);
        return 0;
    }

    /**
     * 1. Creation of bytecode / .class file (jdk)
     * 2. Running this bytecode inside JVM (jre)
     */

    /**
     * Oops - Object oriented programming
     * 1. Abstraction - exhibited by access modifiers and getters, setters
     * 2. Encapsulation - exhibited by classes
     * 3. Inheritance - exhibited by child classes where they extend properties and functionalities of parent
     * 4. Polymorphism -
     *      4.1 -- Compile time polymorphism / function overloading --> Function with same name but diff number or type of argument
     *      4.2 -- Runtime polymorphism
     */
}