package org.anagramfinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public static List<String> readWords(String path) throws IOException {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isBlank()) { // Skip blank lines and trim leading/trailing spaces
                    words.add(line.trim());
                }
            }
        }

        return words;
    }
}
