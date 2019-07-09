package com.jude.dupefinder;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void bytesToHex() {
        String testString = "Testing";
        String base64Result = Utils.bytesToHex(testString.getBytes());
        assertEquals("54657374696e67", base64Result);
    }
}