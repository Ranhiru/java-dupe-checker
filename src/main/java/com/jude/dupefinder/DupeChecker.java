package com.jude.dupefinder;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DupeChecker {

    private String directoryPath;
    private FileDigestCalculator fileDigestCalculator;

    public DupeChecker(String directoryPath, FileDigestCalculator fileDigestCalculator) throws FileNotFoundException {
        checkIfDirectoryExists(directoryPath);

        this.directoryPath = directoryPath;
        this.fileDigestCalculator = fileDigestCalculator;
    }

    public void findDuplicates() {
    }

    private void checkIfDirectoryExists(String path) throws FileNotFoundException {
        if (!directoryExists(path)) {
            throw new FileNotFoundException(String.format("Directory not found - %s", path));
        }
    }

    private boolean directoryExists(String directoryPath) {
        return Files.exists(Path.of(directoryPath));
    }
}
