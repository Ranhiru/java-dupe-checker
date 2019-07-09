package com.jude.dupefinder;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;

public class DupeCheckerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void constructor_GivenInvalidPath_ShouldThrowException() throws FileNotFoundException {
        thrown.expect(FileNotFoundException.class);
        String directoryPath = "/invalid/path";
        new DupeChecker(directoryPath);
    }
}