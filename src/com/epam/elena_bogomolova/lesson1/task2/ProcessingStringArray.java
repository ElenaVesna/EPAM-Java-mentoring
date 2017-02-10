package com.epam.elena_bogomolova.lesson1.task2;

import java.util.*;

public class ProcessingStringArray {

    public static void main(String[] args) {
        ProcessingStringArray app = new ProcessingStringArray();
        app.startProcessingArray();
    }

    private void startProcessingArray() {
        System.out.println("Enter several strings. When you with to stop, enter the string \"STOP\"");
        List<String> strings = getStrings();
//        task 2.1
        findShortestLongestWithLength(strings);
//        task 2.2
        findLongerThanAverage(strings);
//        task 2.3
        findShorterThanAverage(strings);
//        task 2.4
        firstMinDifferentSymbols(strings);
//        task 2.5
        firstAllDifferentSymbols(strings);
//        task 2.6
        secondNumericString(strings);
    }

    //        initial actions
    private List<String> getStrings() {
        List<String> myList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String nextLine = sc.nextLine();
         do {
             myList.add(nextLine);
             nextLine = sc.nextLine();
            } while (!nextLine.equalsIgnoreCase("stop"));
        return myList;
    }

    //        task 2.1
//    найти самую короткую и самую длинную строки. Вывести найденные строки и их длину
    private void findShortestLongestWithLength(List<String> strings) {
        int shortestStringNum = 0;
        int shortLength = strings.get(0).length();
        int longestStringNum = 0;
        int longLength = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() > longLength) {
                longLength = strings.get(i).length();
                longestStringNum = i;
            }
            if (strings.get(i).length() < shortLength) {
                shortLength = strings.get(i).length();
                shortestStringNum = i;
            }
        }
        System.out.println("The shortest string (" + shortLength + " symbols): " + strings.get(shortestStringNum));
        System.out.println("The longest string (" + longLength + " symbols): " + strings.get(longestStringNum));
    }

    //        task 2.2
//    Вывести на консоль те строки, длина которых больше средней, а также длину
    private void findLongerThanAverage(List<String> strings) {
        float average = getAverageLength(strings);
        System.out.println("strings that longer then average:");
        for (String string : strings) {
            if (string.length() > average) {
                System.out.println(string + " (" + string.length() + " symbols)");
            }
        }
    }

    //        task 2.3
//    Вывести на консоль те строки, длина которых меньше средней, а также длину.
    private void findShorterThanAverage(List<String> strings) {
        float average = getAverageLength(strings);
        System.out.println("strings that shorter then average:");
        for (String string : strings) {
            if (string.length() < average) {
                System.out.println(string + " (" + string.length() + " symbols)");
            }
        }
    }

    //        task 2.4
//    Найти первое слово, в котором число различных символов минимально
    private void firstMinDifferentSymbols(List<String> strings) {
        System.out.println("\n The first string with minimum different symbols:");
        int amountUniq = Integer.MAX_VALUE; //amount of unique elements in the string
        int numberUniq = 0; //number of the string with unique elements in the array
        for (int i = 0; i < strings.size(); i++) {
            int num = getUniqElementsNum(strings.get(i));
            if (num < amountUniq) {
                amountUniq = num;
                numberUniq = i;
            }
        }
        System.out.println(strings.get(numberUniq) + " (amount of different symbols: " + amountUniq + ")");
    }

    //        task 2.5
//    Найти первое слово, состоящее только из различных символов.
    private void firstAllDifferentSymbols(List<String> strings) {
        System.out.println("\n The first string with different symbols only:");
        for (String string : strings) {
            if (getUniqElementsNum(string) == string.length()) {
                System.out.println(string);
                return;
            }
        }
        System.out.println("there are no strings with different symbols only");
    }

    //        task 2.6
//    Найти слово, состоящее только из цифр. Если таких слов больше одного, найти второе из них.
    private void secondNumericString(List<String> strings) {
        System.out.println("\n The second (if exists) or single string with numbers only:");
        List<String> intStrings = new ArrayList<>();
        for (String st : strings) {
            if (containsDigitsOnly(st)) {
                intStrings.add(st);
            }
        }
        if (intStrings.size() > 1) {
            System.out.println(intStrings.get(1));
        } else if (intStrings.size() == 1) {
            System.out.println(intStrings.get(0));
        } else {
            System.out.println("there are no string with numbers only");
        }
    }

//    additional supportive methods:
    private float getAverageLength(List<String> strings) {
        int sumLength = 0;
        for (String string : strings) {
            sumLength += string.length();
        }
        float avr = (float) sumLength / strings.size();
        System.out.println("\n Average stings length: " + avr);
        return (avr);
    }

    private int getUniqElementsNum(String item) {
        List<String> symbolsSet = new ArrayList<>();
        for (int j = 0; j < item.length(); j++) {
            symbolsSet.add(String.valueOf(item.charAt(j)));
        }
        return (new HashSet<>(symbolsSet)).size();
    }

    private Boolean containsDigitsOnly(String item) {
        for (int j = 0; j < item.length(); j++) {
             if (!Character.isDigit(item.charAt(j))){
                 return false;
             }
        }
        return true;
    }
}
