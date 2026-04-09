package game;


import hangman.game.Game;
import hangman.game.GameStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GameTest {

    @Test
    void shouldRevealCorrectLetter() {
        Game game = new Game("кот", 5);

        game.guess('к');

        Assertions.assertEquals("к**", game.getMaskedWord());
    }

    @Test
    void shouldCountWrongAttempts() {
        Game game = new Game("кот", 5);

        game.guess('а');

        Assertions.assertEquals(4, game.getRemainingAttempts());
    }

    @Test
    void shouldDetectWin() {
        Game game = new Game("кот", 5);

        game.guess('к');
        game.guess('о');
        game.guess('т');

        Assertions.assertEquals(GameStatus.WON, game.getStatus());
    }

    @Test
    void shouldDetectLose() {
        Game game = new Game("кот", 2);

        game.guess('а');
        game.guess('б');

        Assertions.assertEquals(GameStatus.LOST, game.getStatus());
    }
}

