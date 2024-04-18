package io.github.samsalmag.benchmarkheuristics.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for fetching .jar files.
 *
 * @author Sam Salek
 */
public class JarFetcher {

    /**
     * Gets all .jar files from the given directory.
     *
     * @param directoryPath Directory with .jar files.
     * @return List of File instances pointing to the .jar files.
     */
    public static List<File> getDependencyJars(String directoryPath) {
        List<File> jarFiles = new ArrayList<>();

        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            System.err.println("Provided path is not a directory.");
            return jarFiles;
        }

        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".jar"));
        if (files == null) {
            System.err.println("Failed to list files in the directory.");
            return jarFiles;
        }

        jarFiles.addAll(Arrays.asList(files));
        return jarFiles;
    }
}
