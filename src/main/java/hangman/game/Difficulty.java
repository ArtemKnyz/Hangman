package hangman.game;

public enum Difficulty {
    EASY(8),
    MEDIUM(6),
    HARD(4);

    private final int maxErrors;

    Difficulty(int maxErrors) {
        this.maxErrors = maxErrors;
    }

    public int getMaxErrors() {
        return maxErrors;
    }
}