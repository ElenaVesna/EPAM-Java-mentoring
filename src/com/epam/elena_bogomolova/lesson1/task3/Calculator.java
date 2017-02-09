package com.epam.elena_bogomolova.lesson1.task3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private float result;
    private float number;
    private boolean correctinput;

    public static void main(String[] args) throws IOException {
        Calculator app = new Calculator();
        app.startCalculator();
    }

    private void startCalculator() throws IOException {
        printWelcomeMenu();
        boolean continueworking = true;
        while (continueworking) {
            float num1 = getNumber(1);
            String operation = getOperation();
            float num2 = getNumber(2);
            calculateAndShowResult(num1, num2, operation);
            continueworking = checkForContinue();
        }
    }

    private boolean checkForContinue() throws IOException {
        System.out.println("Do you want to continue? Print N or \"no\" if you want to stop calculations. Enter any other symbol to continue.");
        Scanner sc = new Scanner(System.in);
        String wishtocontinue = sc.nextLine();
        if (wishtocontinue.equalsIgnoreCase("n") || wishtocontinue.equalsIgnoreCase("no")) {
            System.out.println("Goodbye!");
            return false;
        } else {
            return true;
        }
    }

    private void printWelcomeMenu() {
        System.out.println("Hi, I'm Calculator! ");
        System.out.println("I can sum (+), subtract (-), multiply (*) and divide (/) numbers for you!");
        System.out.println();
        System.out.println("How to work: input first number, press Enter, " +
                "input operation sign (+, -, * or /), " +
                "press Enter, input second number, press Enter");
        System.out.println();
        System.out.println("Let's begin!");
    }

    private float getNumber(int i) {
        correctinput = false;
        String num = "";
        if (i == 1) {
            num = "first";
        }
        if (i == 2) {
            num = "second";
        }
        System.out.println("hint: enter " + num + " number and press Enter");
        while (!correctinput) {
            try {
                Scanner sc = new Scanner(System.in);
                number = sc.nextFloat();
                correctinput = true;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect data entered! Try again. Please enter " + num + " number");
            }
        }
        return number;
    }

    private String getOperation() {
        correctinput = false;
        String operation = null;
        while (!correctinput) {
            System.out.println("hint: enter operation (+, -, * or /) and press Enter");
            Scanner sc = new Scanner(System.in);
            operation = sc.nextLine();
            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                correctinput = true;
            } else System.out.println(" You entered incorrect operator, please try again");
        }
        return operation;
    }

    private void calculateAndShowResult(float num1, float num2, String operation) {
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }
        System.out.println(num1 + operation + num2 + " = " + result);
    }
}
