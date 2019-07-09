package com.jude.dupefinder;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        String directory = "/Users/ranhiru/workspace/dupe-images/img"; //TODO: Get from args

        DupeChecker checker;

        try {
            checker = new DupeChecker(directory);
            checker.printDuplicates();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
