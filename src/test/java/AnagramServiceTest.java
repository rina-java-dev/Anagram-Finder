import org.anagramfinder.AnagramService;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AnagramServiceTest {

    @Test
    void shouldGroupAnagramsCorrectly() {
        List<String> input = List.of("cat", "act", "tac", "dog", "god", "bird");
        Map<String, List<String>> result = AnagramService.groupAnagrams(input);

        assertEquals(3, result.size());
        assertGroupContains(result, "cat", "act", "tac");
        assertGroupContains(result, "dog", "god");
        assertGroupContains(result, "bird");
    }

    @Test
    void shouldReturnEmptyMapWhenInputIsEmpty() {
        Map<String, List<String>> result = AnagramService.groupAnagrams(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldHandleSingleWord() {
        Map<String, List<String>> result = AnagramService.groupAnagrams(List.of("hello"));
        assertEquals(1, result.size());
        assertGroupContains(result, "hello");
    }

    @Test
    void shouldNotTreatDifferentCasesAsDifferentWords() {
        List<String> input = List.of("Listen", "Silent", "enlist");
        Map<String, List<String>> result = AnagramService.groupAnagrams(input);
        assertEquals(1, result.size());
    }

    @Test
    void shouldGroupAnagramClusters() {
        List<String> input = List.of("abc", "bca", "cab", "xyz", "zyx", "yxz");
        Map<String, List<String>> result = AnagramService.groupAnagrams(input);

        assertEquals(2, result.size());
        result.values().forEach(group -> assertEquals(3, group.size()));
    }


    private void assertGroupContains(Map<String, List<String>> result, String... expectedWords) {
        List<String> expected = List.of(expectedWords);
        assertTrue(
                result.values().stream().anyMatch(group -> group.containsAll(expected) && group.size() == expected.size()),
                "Expected group with: " + expected
        );
    }

}