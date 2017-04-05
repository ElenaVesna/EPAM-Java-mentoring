package com.epam.elena_bogomolova.lesson3;


public class ErrorException extends Error {

    public void timeOfError() {
        System.out.println("--------Error occurs at " + System.currentTimeMillis());
    }

}
