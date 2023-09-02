package org.example;

import java.util.List;

public interface SampleInterface extends Int1, Int2 {

    // c --> c (extends)
    // i --> i (extends)
    // c --> i (implements)

    int a = 10;

    default int add(int a, int b){
        return a + b;
    }

    int subtract(int a, int b);

    default int multiply(int a, int b){
        return a * b;
    }

//    int size();

    @Override
    default int size() {
        return Int2.super.size();
    }
}
