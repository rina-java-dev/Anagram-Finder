# Anagram Finder

## Description

This Java program reads words from a text file and groups them by anagrams — words made of the same letters in any order.

## Requirements

- Java 11 or higher
- Maven (optional, if you use Maven for build)

## How to Build and Run

## How to Compile and Run (Without Maven)

### Compile the Project

- Use `javac` to compile all `.java` files from the `src/main/java` directory and output compiled `.class` files to the `out` folder:
  javac -d out src/main/java/*.java
- If your files are organized into subpackages, use a recursive pattern:
  javac -d out src/main/java/**/*.java

### Run the Program
- To run the compiled program, use java and pass the path to the input file (or omit it to use the default):

java -cp out org.anagramfinder.AnagramFinderApp path/to/input.txt

Example:

java -cp out org.anagramfinder.AnagramFinderApp

This will print groups of anagrams line by line.



### Using Maven (optional)

1. Build:

   mvn clean package

2. Run:

   java -jar target/Anagram-Finder-1.0-SNAPSHOT.jar path/to/input.txt


## Example

- Input file sample.txt:

cat
act
tree
race
care
acre
bee

- Expected output:

act cat
acre care race
tree
bee

## Testing

JUnit 5 tests are included in the src/test folder.

- Run tests with:

mvn test

- or run the AnagramServiceTest class directly from your IDE.

## Notes

- The program currently treats words as case-insensitive.
- Blank lines in the input file are ignored.
- Designed for easy extension and maintenance.

## Contact
Author: Marina Gumeniuc
Email: rinagumeniuk.java@gmail.com

