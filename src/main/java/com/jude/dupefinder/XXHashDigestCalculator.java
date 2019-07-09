package com.jude.dupefinder;

import net.openhft.hashing.LongHashFunction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class XXHashDigestCalculator implements FileDigestCalculator {
    @Override
    public String getDigestForFile(Path path) throws IOException {
        byte[] fileContent = Files.readAllBytes(path);
        long hash = LongHashFunction.xx().hashBytes(fileContent);
        return Long.toString(hash);
    }
}
