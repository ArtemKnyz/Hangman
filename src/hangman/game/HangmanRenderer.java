package hangman.game;

public class HangmanRenderer {

    private final String[] stages = {
            "=========\n  |   |\n      |\n      |\n      |\n      |\n=========",
            "=========\n  |   |\n  O   |\n      |\n      |\n      |\n=========",
            // ...
    };

    public String getStage(int errors) {
        if (errors < 0) errors = 0;
        if (errors >= stages.length) errors = stages.length - 1;
        return stages[errors];
    }

    public int getMaxErrors() {
        return stages.length - 1;
    }
}