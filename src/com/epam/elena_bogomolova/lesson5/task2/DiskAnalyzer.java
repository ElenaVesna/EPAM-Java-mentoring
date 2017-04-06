package com.epam.elena_bogomolova.lesson5.task2;

import java.io.File;
import java.io.FileFilter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DiskAnalyzer {

    private static int nBig = 5;
    private static String path;

    private static final String FUNCTIONS_LIST = "(1 - to find the file with max 'S' letters in name \n2 - find " + nBig + " biggest files \n3 - calculate medium file size \n4 - find number of files witch names begin with every letter)";
    private static final String CHOOSE_FUNCTION = "Enter number for function you want to run and press Enter";


    public static void main(String[] args) {

        path = getPath();
        selectFunctionToRun();

    }

    private static void selectFunctionToRun() {
        System.out.println(CHOOSE_FUNCTION);
        System.out.println(FUNCTIONS_LIST);
        Scanner sc = new Scanner(System.in);
        int fNumber = 0;
        while (fNumber != 1 && fNumber != 2 && fNumber != 3 && fNumber != 4) {
            try {
                fNumber = sc.nextInt();
            } catch (InputMismatchException e) {
                    System.out.println("Incorrect input. Try again");
                    System.out.println(FUNCTIONS_LIST);
                }
            }
        runFunct(fNumber);
    }

    private static void runFunct(int functNumber) {
        switch (functNumber) {
            case 1 : findFileNameWithMaxS(path);
            break;
            case 2 : findNBiggest(nBig, path);
            break;
            case 3 : mediumFileSize(path);
            break;
            case 4 : filesByFirstLetter(path);
        }
    }

    private static void filesByFirstLetter(String path) {
    }

    private static void mediumFileSize(String path) {

    }

    private static void findNBiggest(int nBig, String path) {

    }

    private static void findFileNameWithMaxS(String path) {
        File folder = new File(path);
        File[] allFiles = getListFilesWithS(folder);
        if (allFiles.length > 0) {
            File maxS = getFileWithMaxChar(allFiles, "s");
            System.out.println("The path to the file with mas s letters: " + maxS.getPath());
        } else System.out.println("No files with 's' in name in the specified directory");
    }

    private static File getFileWithMaxChar(File[] allFiles, String str) {
        Integer[] numOfLetterS = new Integer[allFiles.length];
        for (int i = 0; i < allFiles.length; i++) {
            numOfLetterS[i] = getNumLetterS(allFiles[i].getName(), str);
        }
        int fileId = 0;
        for (int i = 0; i < numOfLetterS.length; i++) {
            if (numOfLetterS[i] > fileId) {
                fileId = i;
            }
        }
        return allFiles[fileId];
    }

    private static Integer getNumLetterS(String name, String s) {
        int numLetter = 0;
        for (Character ch : name.toCharArray()) {
            if (ch.toString().equals(s)) {
                numLetter += 1;
            }
        }
        return numLetter;
    }

    private static File[] getListFilesWithS(File folder) {
       File[] filesWithSInName = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().contains("s") && f.isFile();
            }
        });
        System.out.println("All files with 's' in name:");
        try {
            for (File f : filesWithSInName) {
                System.out.println(f.getName());
            }
            return filesWithSInName;
        } catch (NullPointerException e) {
            System.out.println("Oops");
        }
        return filesWithSInName;
    }

    private static String getPath() {
        System.out.println("Enter directory you was to look at and press enter");
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
