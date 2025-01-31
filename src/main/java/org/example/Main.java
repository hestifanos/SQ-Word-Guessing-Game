package org.example;

import java.util.*;

import static org.example.WordGuessGame.MAX_ATTEMPTS;

public class Main {
    // Main method to run the game
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordGuessGame game = new WordGuessGame();

        System.out.println("Welcome to the Word Guess Game!");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the 5-letter word.");

        while (game.hasAttemptsLeft()) {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() != 5) {
                System.out.println("Please enter a 5-letter word.");
                continue;
            }

            game.incrementAttempts();

            if (game.isCorrectGuess(guess)) {
                System.out.println("Congratulations! You guessed the word: " + game.getTargetWord());
                break;
            } else {
                System.out.println("Feedback: " + game.getFeedback(guess));
            }

            if (!game.hasAttemptsLeft()) {
                System.out.println("You've used all your attempts. The correct word was: " + game.getTargetWord());
            }
        }

        scanner.close();
    }
}