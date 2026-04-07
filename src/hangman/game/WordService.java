package hangman.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordService {

    private final List<String> words = new ArrayList<>();
    private final Random random = new Random();

    public WordService() {
        loadWords();
    }

    private void loadWords() {

        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("russian-nouns.txt");
        if (is == null) {
            throw new RuntimeException("Файл не найден!");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    words.add(trimmed);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки слов", e);
        }
    }

    public String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}

