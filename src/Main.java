import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            }
            Path p1 = Paths.get("russian-nouns.txt");
            List<String> content = Files.readAllLines(p1);
            Random random = new Random();
            String word = content.get(random.nextInt(34012));
            System.out.println(word);  // здесь вывести зашифрованное слово ****
            String newString = word.replace(word, "*".repeat(word.length()));
            StringBuilder sb = new StringBuilder(newString);
            System.out.println("\n Загаданное слово: " + sb);

            Gallow hangman = new Gallow();
            System.out.println(hangman.hangmanImage[0]);

            while (numberError < countAttempt) {

                System.out.print("Введите букву: ");
                char s = scan.next().charAt(0);
                boolean error = false;

                for (int i = 0; i < word.length(); i++) {
                    if (s == word.charAt(i)) {
                        sb.setCharAt(i, s);
                        error = true;
                    }
                }
                if (!error) {
                    numberError++;
                }
                System.out.println("\n" + hangman.hangmanImage[numberError]);
                System.out.println("Загаданное слово: " + sb);
                System.out.println("Ошибок: " + numberError);
                System.out.println("Осталось " + (countAttempt - numberError) + " попыток \n");
            }
        }
    }
}


