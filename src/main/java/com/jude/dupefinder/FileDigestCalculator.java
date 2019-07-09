package com.jude.dupefinder;

import java.io.IOException;
import java.nio.file.Path;

public interface FileDigestCalculator {
    String getDigestForFile(Path path) throws IOException;
}
