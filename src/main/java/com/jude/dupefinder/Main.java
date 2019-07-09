package com.jude.dupefinder;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        String directory = "/Users/ranhiru/workspace/dupe-images/img"; //TODO: Get from args

        DupeChecker checker;

        try {
            XXHashDigestCalculator digestCalculator = new XXHashDigestCalculator();
            checker = new DupeChecker(directory, digestCalculator);
            checker.findDuplicates();
            checker.printDuplicates();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
