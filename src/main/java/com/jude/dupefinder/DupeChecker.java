package com.jude.dupefinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DupeChecker {

    private Path directoryPath;
    private FileDigestCalculator fileDigestCalculator;
    private HashMap<String, Set<Path>> duplicates;

    public DupeChecker(String directoryPath, FileDigestCalculator fileDigestCalculator) throws FileNotFoundException {
        checkIfDirectoryExists(directoryPath);

        this.directoryPath = Paths.get(directoryPath);
        this.fileDigestCalculator = fileDigestCalculator;
        this.duplicates = new HashMap<>();
    }

    public void findDuplicates() {
        try {
            Stream<Path> files = Files.find(directoryPath, Integer.MAX_VALUE, (filePath, fileAttr) -> fileAttr.isRegularFile());
            files.forEach(path -> handleFilePath(path));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void printDuplicates() {
        this.duplicates.forEach((digest, set) -> {
            if (set.size() == 1) {
                return;
            }

            set.forEach((path) -> {
                System.out.println(path);
            });
            System.out.println();
        });
    }

    private void handleFilePath(Path path) {
        try {
            String digest = fileDigestCalculator.getDigestForFile(path);
            Set<Path> fileSet = duplicates.getOrDefault(digest, new HashSet<>());
            fileSet.add(path);
            duplicates.put(digest, fileSet);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
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
