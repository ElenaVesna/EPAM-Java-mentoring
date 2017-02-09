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
        List<String> mylist = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String nextline = sc.nextLine();
         do {
             mylist.add(nextline);
             nextline = sc.nextLine();
            } while (!nextline.equalsIgnoreCase("stop"));
        return mylist;
    }

    //        task 2.1
//    найти самую короткую и самую длинную строки. Вывести найденные строки и их длину
    private void findShortestLongestWithLength(List<String> strings) {
        int shorteststringnumber = 0;
        int shortlength = strings.get(0).length();
        int longeststringnumber = 0;
        int longlength = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() > longlength) {
                longlength = strings.get(i).length();
                longeststringnumber = i;
            }
            if (strings.get(i).length() < shortlength) {
                shortlength = strings.get(i).length();
                shorteststringnumber = i;
            }
        }
        System.out.println("The shortest string (" + shortlength + " symbols): " + strings.get(shorteststringnumber));
        System.out.println("The longest string (" + longlength + " symbols): " + strings.get(longeststringnumber));
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
        int amountunic = Integer.MAX_VALUE;
        int numberunic = 0;
        for (int i = 0; i < strings.size(); i++) {
//            HashSet<String> unic = getUnicElements(strings, i);
            int num = getUniqElementsNum(strings.get(i));
            if (num < amountunic) {
                amountunic = num;
                numberunic = i;
            }
        }
        System.out.println(strings.get(numberunic) + " (amount of different symbols: " + amountunic + ")");
    }

    //        task 2.5
//    Найти первое слово, состоящее только из различных символов.
    private void firstAllDifferentSymbols(List<String> strings) {
        System.out.println("\n The first string with different symbols only:");
        for (int i = 0; i < strings.size(); i++) {
            if (getUniqElementsNum(strings.get(i)) == strings.get(i).length()) {
                System.out.println(strings.get(i));
                return;
            }
        }
        System.out.println("there are no strings with different symbols only");
    }

    //        task 2.6
//    Найти слово, состоящее только из цифр. Если таких слов больше одного, найти второе из них.
    private void secondNumericString(List<String> strings) {
        System.out.println("\n The second (if exists) or single string with numbers only:");
        List<String> intstrings = new ArrayList<>();
        for (String st : strings) {
            if (containsDigitsOnly(st)) {
                intstrings.add(st);
            }
        }
        if (intstrings.size() > 1) {
            System.out.println(intstrings.get(1));
        } else if (intstrings.size() == 1) {
            System.out.println(intstrings.get(0));
        } else {
            System.out.println("there are no string with numbers only");
        }
    }

//    additional supportive methods:
    private float getAverageLength(List<String> strings) {
        int sumlength = 0;
        for (String string : strings) {
            sumlength += string.length();
        }
        float avr = (float) sumlength / strings.size();
        System.out.println("\n Average stings length: " + avr);
        return (avr);
    }

//    private HashSet<String> getUnicElements(List<String> strings, int i) {
//        List<String> symbolsset = new ArrayList<>();
//        String element = strings.get(i);
//        for (int j = 0; j < element.length(); j++) {
//            symbolsset.add(element.substring(j, j+1));
//        }
//        return new HashSet<>(symbolsset);
//    }

    private int getUniqElementsNum(String item) {
        List<String> symbolsset = new ArrayList<>();
        for (int j = 0; j < item.length(); j++) {
            symbolsset.add(String.valueOf(item.charAt(j)));
        }
        return (new HashSet<>(symbolsset)).size();
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
