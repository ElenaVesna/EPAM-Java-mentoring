package com.epam.elena_bogomolova.lesson5.task2;

import java.io.File;
import java.util.Comparator;

public class FileSizeComparator implements Comparator<File> {
    @Override
    public int compare(File f1, File f2) {
        if(f1.length() < f2.length()) {
            return -1;
        } else if(f1.length() > f2.length()) {
            return 1;
        } return 0;
    }
}
