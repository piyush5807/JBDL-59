package com.example.minorproject1.exceptions;

public class BookLimitExceededException extends Exception{

    public BookLimitExceededException(String msg) {
        super(msg);
    }
}
