package com.perficient.helm.issueObjects.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonFileReader {
    
    
    public static final ArrayList<File> getAllFilesInDirectory(String directory) {
    
        ArrayList<File> files = new ArrayList<File>();
        
        try {
            Files.list(Paths.get(directory)).filter(path->path.toFile().getAbsolutePath().endsWith(".json")).forEach(path->files.add(path.toFile()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to find files in directory " + directory, e);
        }
        
        return files;
    }
}
