package com.jude.dupefinder;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DupeChecker {

    private String directoryPath;

    public DupeChecker(String directoryPath) throws FileNotFoundException {
        this.directoryPath = directoryPath;
        checkIfDirectoryExists();
    }

    public void printDuplicates() {
        System.out.println("Traversing " + directoryPath);
    }

    private void checkIfDirectoryExists() throws FileNotFoundException {
        if (!directoryExists(directoryPath)) {
            throw new FileNotFoundException("Directory not found!");
        }
    }

    private boolean directoryExists(String directoryPath) {
        return Files.exists(Path.of(directoryPath));
    }
}
