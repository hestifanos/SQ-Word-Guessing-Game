import org.example.WordGuessGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class WordGuessGameTest {

    private WordGuessGame game;

    // This method runs before each test to set up the test environment
    @BeforeEach
    public void setUp() {
        game = new WordGuessGame("apple");
    }

    // Test for the constructor and target word initialization
    @Test
    public void testConstructor() {
        assertNotNull(game.getTargetWord());
        assertTrue(game.getTargetWord().length() == 5);
    }

    // Test for providing feedback on guessed word
    @Test
    public void testGetFeedback() {

        String feedback = game.getFeedback("apric");
        assertEquals("ap---", feedback);
    }

    @Test
    public void testFeedbackDoesNotCountDuplicateLettersMoreThanOnce() {
        assertEquals("a+--e", game.getFeedback("allee"));
    }

    @Test
    public void testRejectsGuessesWithInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> game.getFeedback("app"));
    }

    // Test for checking if the guessed word is correct
    @Test
    public void testIsCorrectGuess() {

        assertTrue(game.isCorrectGuess("apple"));
        assertFalse(game.isCorrectGuess("grape"));
    }

    // Test for checking if the player has attempts left
    @Test
    public void testHasAttemptsLeft() {
        for (int i = 0; i < 5; i++) {
            game.incrementAttempts();
        }
        assertTrue(game.hasAttemptsLeft());
        game.incrementAttempts();
        assertFalse(game.hasAttemptsLeft());
    }

    // Test for incrementing the number of attempts
    @Test
    public void testIncrementAttempts() {
        assertEquals(0, game.getAttempts());
        game.incrementAttempts();
        assertEquals(1, game.getAttempts());
    }


}
