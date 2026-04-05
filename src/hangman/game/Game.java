package hangman.game;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private final String word;
    private final Set<Character> guessedLetters = new HashSet<>();
    private final Set<Character> wrongLetters = new HashSet<>();

    private int errors = 0;
    private final int maxErrors;

    public Game(String word, int maxErrors) {
        this.word = word.toLowerCase();
        this.maxErrors = maxErrors;
    }

    public boolean guess(char letter) {
        letter = Character.toLowerCase(letter);

        if (guessedLetters.contains(letter) || wrongLetters.contains(letter)) {
            return false;
        }

        if (word.indexOf(letter) >= 0) {
            guessedLetters.add(letter);
            return true;
        } else {
            wrongLetters.add(letter);
            errors++;
            return false;
        }
    }

    public String getMaskedWord() {
        StringBuilder sb = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (guessedLetters.contains(c)) {
                sb.append(c);
            } else {
                sb.append('*');
            }
        }
        return sb.toString();
    }

    public GameStatus getStatus() {
        if (errors >= maxErrors) {
            return GameStatus.LOST;
        }
        if (!getMaskedWord().contains("*")) {
            return GameStatus.WON;
        }
        return GameStatus.IN_PROGRESS;
    }

    public int getErrors() {
        return errors;
    }

    public int getRemainingAttempts() {
        return maxErrors - errors;
    }

    public Set<Character> getWrongLetters() {
        return wrongLetters;
    }

    public String getWord() {
        return word;
    }
}
