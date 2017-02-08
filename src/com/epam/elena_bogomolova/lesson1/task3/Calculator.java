package com.epam.elena_bogomolova.lesson1.task3;

import jdk.nashorn.internal.ir.Symbol;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator app = new Calculator();
        app.startCalculator();
    }

    private void startCalculator() {
        printWelcomeMenu();
        long num1 = getFirstNumber();
        String operation = getOperation();
        long num2 = getSecondNumber();
        calculateAndShowResult(num1, num2, operation);

    }

    private void printWelcomeMenu() {
        System.out.println("calculator started");
        System.out.println("input first number, press Enter, " +
                "input operation sign (+, -, * or /), " +
                "press Enter, input second number, press Enter");
    }

    private long getFirstNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("hint: enter firts number and press Enter");
        long firstNumber = Long.parseLong(sc.next());
        sc.close();
        return firstNumber;
    }

    private String getOperation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("hint: enter operation and press Enter");
        String operation = sc.next();
        sc.close();
        return operation;
    }

    private long getSecondNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("hint: enter second number and press Enter");
//        long secondNumber = Long.parseLong(sc.next());
        return Long.parseLong(sc.next());
    }

    private void calculateAndShowResult(long num1, long num2, String operation) {
        System.out.println(num1 + operation + num2 + " = ");
    }


}
