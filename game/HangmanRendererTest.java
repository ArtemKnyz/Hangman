package hangman.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HangmanRendererTest {

    @Test
    void shouldReturnFirstStage() {
        HangmanRenderer renderer = new HangmanRenderer();

        String stage = renderer.getStage(0);

        assertTrue(stage.contains("|"));
    }

    @Test
    void shouldClampTooLargeErrors() {
        HangmanRenderer renderer = new HangmanRenderer();

        String stage = renderer.getStage(100);

        assertNotNull(stage);
    }
}
