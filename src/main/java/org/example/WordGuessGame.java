package org.example;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class WordGuessGame {
    private static final List<String> WORDS = List.of("apple", "grape", "peach", "berry", "melon");
    private static final int WORD_LENGTH = 5;
    static final int MAX_ATTEMPTS = 6;

    private final String targetWord;
    private int attempts;

    public WordGuessGame() {
        targetWord = WORDS.get(new Random().nextInt(WORDS.size()));
    }

    public WordGuessGame(String targetWord) {
        this.targetWord = normalizeWord(targetWord);
    }

    public String getFeedback(String guess) {
        String normalizedGuess = normalizeWord(guess);
        char[] feedback = new char[WORD_LENGTH];
        int[] remainingLetters = new int[26];

        for (int index = 0; index < WORD_LENGTH; index++) {
            char targetLetter = targetWord.charAt(index);
            char guessedLetter = normalizedGuess.charAt(index);
            if (guessedLetter == targetLetter) {
                feedback[index] = targetLetter;
            } else {
                remainingLetters[targetLetter - 'a']++;
            }
        }

        for (int index = 0; index < WORD_LENGTH; index++) {
            if (feedback[index] != '\0') {
                continue;
            }

            int letterIndex = normalizedGuess.charAt(index) - 'a';
            if (remainingLetters[letterIndex] > 0) {
                feedback[index] = '+';
                remainingLetters[letterIndex]--;
            } else {
                feedback[index] = '-';
            }
        }

        return new String(feedback);
    }

    public boolean isCorrectGuess(String guess) {
        return guess != null && guess.trim().toLowerCase(Locale.ROOT).equals(targetWord);
    }

    public boolean hasAttemptsLeft() {
        return attempts < MAX_ATTEMPTS;
    }

    public void incrementAttempts() {
        attempts++;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getTargetWord() {
        return targetWord;
    }

    private static String normalizeWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word must not be null.");
        }

        String normalizedWord = word.trim().toLowerCase(Locale.ROOT);
        if (normalizedWord.length() != WORD_LENGTH
                || !normalizedWord.chars().allMatch(character -> character >= 'a' && character <= 'z')) {
            throw new IllegalArgumentException("Word must contain five letters from A to Z.");
        }
        return normalizedWord;
    }
}
