package com.epam.elena_bogomolova.lesson5.task2;


import java.io.File;
import java.util.Scanner;

public class DiskAnalyzer {
    public static void main(String[] args) {

        String path = getPath();
//        System.out.println(path);
        findFileNameWithMaxS(path);
    }

    private static void findFileNameWithMaxS(String path) {
        File folder = new File(path);

//        String[] namesWithS = folder.list((dir, name) -> name.contains("s"));
        File[] allFiles = getListFilesWithS(folder);
        if (allFiles.length > 0) {
            System.out.println("there are files with s");
            File maxS = getFileWithMaxChar(allFiles, "s");
        } else System.out.println("No files with 's' in name in the specified directory");

    }

    private static File getFileWithMaxChar(File[] allFiles, String s) {
        return null;
    }

    private static File[] getListFilesWithS(File folder) {
        File[] filesWithSInName = folder.listFiles((file, name) -> name.contains("s") && file.isFile());
        try {
//            for (File f : filesWithSInName) {
//                System.out.println(f.getName());
//            }
            return filesWithSInName;
        } catch (ArrayIndexOutOfBoundsException e) {
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

    private void myMethod() {
        System.out.println("Hi");
    }
}
