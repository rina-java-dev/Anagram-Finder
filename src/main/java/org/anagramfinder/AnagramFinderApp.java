package org.anagramfinder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnagramFinderApp {
    public static void main(String[] args) {
        String filePath = args.length > 0
                ? args[0]
                : "src/main/java/org/anagramfinder/sample.txt";

        try {
            List<String> words = FileReaderUtil.readWords(filePath);
            Map<String, List<String>> anagramGroups = AnagramService.groupAnagrams(words);

            anagramGroups.values().forEach(group ->
                    System.out.println(String.join(" ", group)));

        } catch (IOException e) {
            System.err.println("Failed to process file: " + e.getMessage());
        }
    }
}
