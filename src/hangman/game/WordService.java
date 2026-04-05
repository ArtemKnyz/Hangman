package hangman.game;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        try {
            System.out.println("Путь поиска: " + getClass().getClassLoader().getResource(".").getPath());
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("resources/russian-nouns.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }

        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки слов", e);
        }
    }

    public String getRandomWord() {
        return words.get(random.nextInt(words.size()));
    }
}

