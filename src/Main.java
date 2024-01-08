import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int numberError;

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int countAttempt = 6;
        int startOrNot;

        while (true) {
            System.out.println("Начнем новую игру?");
            System.out.println("Да - 1, Нет - любая другая цифра");
            try {
                startOrNot = Integer.parseInt(scan.next());
                if (startOrNot != 1) {
                    System.out.println("Игра окончена!");
                    scan.close();
                    System.exit(1);
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
                continue;
            }
            Path p1 = Paths.get("src/resources/russian-nouns.txt");
            List<String> content = Files.readAllLines(p1);
            Random random = new Random();
            String word = content.get(random.nextInt(34012));
            //System.out.println(word);  // зашифрованное слово ****
            String newString = word.replace(word, "*".repeat(word.length()));
            StringBuilder sb = new StringBuilder(newString);
            System.out.println("\n Загаданное слово: " + sb);

            Gallow hangman = new Gallow();
            System.out.println(hangman.hangmanImage[0]);

            List<String> wrongLetters = new ArrayList<>();

            while (numberError < countAttempt) {


                System.out.print("Введите букву: ");
                char s = Character.toLowerCase(scan.next().charAt(0));
                boolean error = false;

                for (int i = 0; i < word.length(); i++) {

                    if (s == word.toLowerCase().charAt(i)) {
                        sb.setCharAt(i, s);
                        error = true;
                    }
                }
                if (!error) {
                    if (wrongLetters.contains(String.valueOf(s))) {
                        System.out.println("Символ введен повторно");
                        continue;

                    }
                    numberError++;
                    wrongLetters.add(String.valueOf(Character.toLowerCase(s)));

                }

                System.out.println("\n" + hangman.hangmanImage[numberError]);
                if (numberError == countAttempt) {
                    System.out.println("Загаданное слово: " + word);
                } else {
                    System.out.println("Загаданное слово: " + sb);
                }
                System.out.print("Ошибки" + "(" + numberError + "): ");
                wrongLetters.forEach(System.out::print);
                System.out.println("\nОсталось попытки: " + (countAttempt - numberError) + "\n");
            }
        }
    }
}


