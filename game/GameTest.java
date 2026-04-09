package hangman.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void shouldRevealCorrectLetter() {
        Game game = new Game("кот", 5);

        game.guess('к');

        assertEquals("к**", game.getMaskedWord());
    }

    @Test
    void shouldCountWrongAttempts() {
        Game game = new Game("кот", 5);

        game.guess('а');

        assertEquals(4, game.getRemainingAttempts());
    }

    @Test
    void shouldDetectWin() {
        Game game = new Game("кот", 5);

        game.guess('к');
        game.guess('о');
        game.guess('т');

        assertEquals(GameStatus.WON, game.getStatus());
    }

    @Test
    void shouldDetectLose() {
        Game game = new Game("кот", 2);

        game.guess('а');
        game.guess('б');

        assertEquals(GameStatus.LOST, game.getStatus());
    }
}
