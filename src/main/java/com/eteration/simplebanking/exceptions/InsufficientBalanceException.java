package com.eteration.simplebanking.exceptions;


// This class is a place holder you can change the complete implementation
public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String errorMessage){
        super(errorMessage);
    }
}
