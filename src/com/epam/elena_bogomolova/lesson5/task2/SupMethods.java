package com.epam.elena_bogomolova.lesson5.task2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class SupMethods {

    static File getFileWithMaxChar(File[] allFiles, String str) {
        Integer[] numOfLetterS = new Integer[allFiles.length];
        for (int i = 0; i < allFiles.length; i++) {
            numOfLetterS[i] = getNumLetterS(allFiles[i].getName(), str);
        }
        int fileId = 0;
        int maxLetters = 0;
        for (int i = 0; i < numOfLetterS.length; i++) {
            if (numOfLetterS[i] > maxLetters) {
                fileId = i;
                maxLetters = numOfLetterS[i];
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

    static File[] getListFilesWithS(File folder) {
       File[] filesWithSInName = folder.listFiles(f -> f.getName().contains("s") && f.isFile());
        System.out.println("---All files with 's' in name:");
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

    static int countFirstLetters(List<Character> listFirstLetters, char letter) {
        int numFilesBeginL = 0;
        for (Character listFirstLetter : listFirstLetters) {
            if (listFirstLetter.equals(letter)) {
                numFilesBeginL += 1;
            }
        }
        return numFilesBeginL;
    }

    static List<Character> getFirstCharsList(File[] fileNames) {
        List<Character> listFirstLetters = new ArrayList<>();
        try {
            for (File fileName : fileNames) {
                String st = fileName.getName().toUpperCase().substring(0, 1);
                if (st.matches("[A-Z]|[А-Я]")) {
                    listFirstLetters.add(st.charAt(0));
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Specified directory is empty");
        }
        return listFirstLetters;
    }
}
