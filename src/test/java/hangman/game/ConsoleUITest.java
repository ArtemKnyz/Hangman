package game;

import hangman.game.Difficulty;
import hangman.ui.ConsoleUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleUITest {
    private final ConsoleUI ui = new ConsoleUI();

    @Test
    void shouldReturnMedium_whenInputIs2() {
        Difficulty result = ui.parseDifficulty("2");
        assertEquals(Difficulty.MEDIUM, result);
    }

    @Test
    void shouldReturnEasy_whenInputIs1() {
        Difficulty result = ui.parseDifficulty("1");
        assertEquals(Difficulty.EASY, result);
    }

    @Test
    void shouldReturnHard_whenInputIs3() {
        Difficulty result = ui.parseDifficulty("3");
        assertEquals(Difficulty.HARD, result);
    }

    @Test
    void shouldReturnDefault_whenInputInvalid() {
        Difficulty result = ui.parseDifficulty("abc");
        assertEquals(Difficulty.MEDIUM, result);
    }
}

