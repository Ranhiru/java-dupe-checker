package com.jude.dupefinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class MD5FileDigestCalculator implements FileDigestCalculator {

    @Override
    public String getDigestForFile(Path path) throws IOException {
        try {
            byte[] fileContent = Files.readAllBytes(path);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] fileBytes = md.digest(fileContent);
            return Utils.bytesToHex(fileBytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
