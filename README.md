# Word Guessing Game

A Java word-guessing game with a small built-in word list, a six-attempt limit, and feedback for letters in the correct position or elsewhere in the target word.

## Requirements

- JDK 23 (the compiler level configured in `pom.xml`)
- Apache Maven

## Build and test

```bash
mvn test
mvn package
```

Run `org.example.Main` from your IDE or terminal. The `WordGuessGame` class contains the game state and feedback logic; tests can supply a known target word for repeatable cases.

## Project layout

```text
src/main/java/org/example/WordGuessGame.java   Game rules and feedback
src/main/java/org/example/Main.java            Command-line entry point
src/test/java/                                 JUnit tests
```
