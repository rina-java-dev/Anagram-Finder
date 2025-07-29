package org.anagramfinder;

import java.util.*;

public class AnagramService {
    public static Map<String, List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            String key = sortLetters(word);
            // Add the word to its anagram group (create group if it doesn't exist yet)
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return map;
    }

    private static String sortLetters(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
