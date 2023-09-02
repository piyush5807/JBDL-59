package org.example;

import java.util.ArrayList;
import java.util.List;

public class Child extends Parent{

    Child(){
        super(10);
        System.out.println("Inside Child: constructor " + this);
    }

    public void funcC(){
        System.out.println("Inside Child: funcC");
    }

    public void funcA(){
        System.out.println("Inside Child: funcA");
    }

    public static void main(String[] args) {

        // References are only used for accessing
        // Functions are called of the initalizing class


        // List --> 10 functions
        // ArrayList --> 10 + 5 more functions
        ArrayList<Integer> al = new ArrayList<>();
//        al.ensureCapacity(10); //
//
        List<Integer> al2 = new ArrayList<>();
//        al2.ensureCapacity(10);

//      Reference child = Instance child
        Child c1 = new Child();

//      Reference parent = Instance child
        Parent c2 = new Child();

        c1.funcC();

//        c2.funcC();
//
        Parent c3 = new Parent();
//
//        c1.funcA();
//        c2.funcA();
//        c3.funcA();
//
//
//        c1.funcB();
//        c2.funcB();
//        c3.funcB();


//        Child c4 = new Parent(); // if this would be valid
//
//        c4.funcC();


        // Parent - A, B
        // Child --> Parent [A, B, C]




//        System.out.println(c1 + " " + c2);


        //   Company which built a DS
        //      X class
        //      ||
        //   Google , Microsoft, Meta
        //   X' ==> some more functions, they are using X' and not X

        // Before a child class constructor is executed, parent class constructor will be executed
        // Before a parent class destructor is executed, child class destructor will be executed during object deletion
    }
}
