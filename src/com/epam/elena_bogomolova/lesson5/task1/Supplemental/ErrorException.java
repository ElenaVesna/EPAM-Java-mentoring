package com.epam.elena_bogomolova.lesson5.task1.Supplemental;


public class ErrorException extends Error {

    public void timeOfError() {
        System.out.println("--------Error occurs at " + System.currentTimeMillis());
    }

}
