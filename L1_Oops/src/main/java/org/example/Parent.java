package org.example;

public class Parent extends GrandParent{

    Parent(){
        System.out.println("Inside Parent: default constructor " + this);
    }

    Parent(int a){
        System.out.println("Inside Parent: parameterized constructor " + this);
    }

    public void funcA(){
        System.out.println("Inside Parent: funcA");
    }

    public void funcB(){
        System.out.println("Inside Parent: funcB");
    }


}
