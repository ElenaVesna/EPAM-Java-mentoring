package com.epam.elena_bogomolova.lesson5.task2;

import java.io.File;
import java.util.*;
import java.util.List;

public class DiskAnalyzer extends SupMethods {

    private static int nBig = 5;
    private static String letter = "s";
    private static File folder;
    private static File[] filesList;

    private static final String FUNCTIONS_LIST = "(1 - to find the file with max 'S' letters in name \n2 - find " + nBig + " biggest files \n3 - calculate medium file size \n4 - find number of files witch names begin with every letter)";
    private static final String CHOOSE_FUNCTION = "Enter number for function you want to run and press Enter";

    public static void main(String[] args) {
        String path = getPath();
        folder = new File(path);
        File[] files = folder.listFiles();
        if (files.length > 0) {
            selectFunctionToRun();
            askUserToContinue();
        } else {
            System.out.println("Selected directory is empty, no functions available");
            System.out.println("The program closes");
        }
    }

    private static void selectFunctionToRun() {
        System.out.println(CHOOSE_FUNCTION);
        System.out.println(FUNCTIONS_LIST);
        int fNumber = 0;
        while (fNumber != 1 && fNumber != 2 && fNumber != 3 && fNumber != 4) {
            try {
                Scanner sc = new Scanner(System.in);
                fNumber = sc.nextInt();
                if (fNumber > 4 || fNumber < 1) {
                    System.out.println("No function connected with the entered number, try again");
                }
            } catch (InputMismatchException e) {
                    System.out.println("Incorrect input. Try again");
                    System.out.println(FUNCTIONS_LIST);
                }
            }
        runFunct(fNumber);
    }

    private static void askUserToContinue() {
        boolean wishToContinue = true;
        while (wishToContinue) {
            System.out.println("Do you wish to run another function for the same path? Enter Y or \"yes\" to continue ");
            Scanner sc = new Scanner(System.in);
            String contRun = sc.nextLine();
            if (contRun.equalsIgnoreCase("y") || contRun.equalsIgnoreCase("yes")) {
                DiskAnalyzer.selectFunctionToRun();
            } else {
                System.out.println("Goodbye!");
                wishToContinue = false;
            }
        }
    }

    private static void runFunct(int functNumber) {
        switch (functNumber) {
            case 1 : findFileNameWithMaxSelectedLetterNum(letter);
            break;
            case 2 : findNBiggest(nBig);
            break;
            case 3 : averageFileSize();
            break;
            case 4 : filesByFirstLetter();
        }
    }

    private static void filesByFirstLetter() {
//        File[] files = folder.listFiles();
        List<Character> listFirstLetters = getFirstCharsList(filesList);
        HashSet<Character> usedLetters = new HashSet<>(listFirstLetters);
        System.out.println("---Amount of files/folders, which names begin with letters:");
        countAndPrintNumByLetters(filesList, listFirstLetters, usedLetters);
    }

    private static void countAndPrintNumByLetters(File[] fileNames, List<Character> listFirstLetters, HashSet<Character> usedLetters) {
        int letterBeginnings = 0;
        for (char letter : usedLetters) {
            int numFilesBeginL = countFirstLetters(listFirstLetters, letter);
            System.out.println(letter + ": " + numFilesBeginL);
            letterBeginnings += numFilesBeginL;
        }
        int notLetter = fileNames.length - letterBeginnings;
        if (notLetter > 0) {
            System.out.println("The number of files with symbolic beginnings: " + notLetter);
        } else System.out.println("No files with symbolic beginnings");
    }

    private static void averageFileSize() {
//        File[] files = folder.listFiles();
        double sumSizeKb = 0;
        try {
            for (File f: filesList) {
                sumSizeKb += f.length() / 1024;
            }
            double avrSize = sumSizeKb / filesList.length;
            System.out.println("Average file size is (in kb): " + avrSize);
        } catch (NullPointerException e) {
            System.out.println("Specified folder is empty");
        }

    }

    private static void findNBiggest(int nBig) {
        double[] listSizes = new double[filesList.length - 1];
        Arrays.sort(listSizes);

    }


    private static void findFileNameWithMaxSelectedLetterNum(String letter) {
//        File[] allFiles = getListFilesWithS(folder);
        if (filesList.length > 0) {
            File maxS = getFileWithMaxChar(filesList, letter);
            System.out.println("\nThe path to the file with max number 's' letters: " + maxS.getPath());
        } else System.out.println("No files with 's' in name in the specified directory");
    }

    private static String getPath() {
        System.out.println("Enter directory you want to look at and press enter");
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine().toLowerCase();
        File dir = new File(path);
        while (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Incorrect or not existing directory path entered, try again");
            System.out.println("(hint: if you want to exit programme - enter 'exit' string)");
            path = sc.nextLine().toLowerCase();
            if (path.equals("exit")) {
                break;
            } else dir = new File(path);
        }
        return path;
    }
}
