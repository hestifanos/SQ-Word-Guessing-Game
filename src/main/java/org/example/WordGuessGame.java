package org.example;

import java.util.*;

public class WordGuessGame {
    private static final List<String> WORDS = Arrays.asList("apple", "grape", "peach", "berry", "melon");
    static final int MAX_ATTEMPTS = 6;
    private String targetWord;
    public int attempts;

    // Constructor to initialize the game with a random target word and reset attempts
    public WordGuessGame() {
        Random random = new Random();
        targetWord = WORDS.get(random.nextInt(WORDS.size()));
        attempts = 0;
    }

    // Constructor to initialize the game with a specific target word (for testing)
    public WordGuessGame(String targetWord) {
        this.targetWord = targetWord;
        attempts = 0;
    }


    // Provides feedback on the guessed word
    // Correct letter in correct position: the letter itself
    // Correct letter in wrong position: '+'
    // Incorrect letter: '-'
    public String getFeedback(String guess) {
        StringBuilder feedback = new StringBuilder();
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == targetWord.charAt(i)) {
                feedback.append(guess.charAt(i));
            } else if (targetWord.contains(String.valueOf(guess.charAt(i)))) {
                feedback.append("+");
            } else {
                feedback.append("-");
            }
        }
        return feedback.toString();
    }

    // Checks if the guessed word is correct
    public boolean isCorrectGuess(String guess) {
        return guess.equals(targetWord);
    }

    // Checks if the player has attempts left
    public boolean hasAttemptsLeft() {
        return attempts < MAX_ATTEMPTS;
    }

    // Increments the number of attempts made by the player
    public void incrementAttempts() {
        attempts++;
    }

    // Returns the target word
    public String getTargetWord() {
        return targetWord;
    }
}
