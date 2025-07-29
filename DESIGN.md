# Design Document — Anagram Finder

## Overview

The program reads a list of words from a text file and groups them into anagram clusters — words that contain the same letters in any order.

## Architecture

- **org.anagramfinder.AnagramFinderApp**: Entry point. Handles file input and output.
- **org.anagramfinder.FileReaderUtil**: Reads words from the input file, skipping blank lines.
- **org.anagramfinder.AnagramService**: Contains core logic to group words by sorted letter keys.

## Design Decisions

1. **Single Responsibility Principle (SRP)**
    - Each class has one clear responsibility:
        - File reading,
        - Anagram grouping,
        - Application orchestration.

2. **Open/Closed Principle (OCP)**
    - The design allows extending input sources or output formats by adding new classes without modifying existing ones.

3. **Abstraction & Modularity**
    - Separation of concerns makes code easier to maintain and test.
    - `org.anagramfinder.AnagramService` is reusable independently from I/O logic.

4. **Data Structure Choice**
    - A `HashMap<String, List<String>>` is used to group anagrams.
    - Key: sorted characters of a word (e.g., `"act"` for `"cat"`).
    - Value: list of all words matching that key.

5. **Scalability Considerations**
    - **For millions of words:**
        - Use streaming file processing instead of reading entire file into memory.
        - Consider external sorting or databases if data doesn’t fit in RAM.
    - **For billions of words:**
        - Distributed processing frameworks (e.g., Hadoop, Spark).
        - Partition data by prefixes or hashes.
        - Store intermediate results on disk or in distributed storage.

6. **Performance**
    - Sorting each word’s characters is `O(K log K)`, with `K` = word length.
    - Total complexity roughly `O(N * K log K)` for `N` words.
    - Memory scales with input size, storing all words grouped.

## External Libraries

- Only Java standard libraries are used for simplicity and portability.

## Resources 
- https://www.baeldung.com/reading-file-in-java 
