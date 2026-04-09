package game;

import hangman.game.HangmanRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HangmanRendererTest {

    @Test
    void shouldReturnFirstStage() {
        HangmanRenderer renderer = new HangmanRenderer();

        String stage = renderer.getStage(0);

        Assertions.assertTrue(stage.contains("|"));
    }

    @Test
    void shouldClampTooLargeErrors() {
        HangmanRenderer renderer = new HangmanRenderer();

        String stage = renderer.getStage(100);

        Assertions.assertNotNull(stage);
    }
}