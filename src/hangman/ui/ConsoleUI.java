package hangman.ui;


import hangman.game.Game;
import hangman.game.GameStatus;
import hangman.game.HangmanRenderer;
import hangman.game.WordService;


import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);
    private final WordService wordService = new WordService();

    public void start() {

        while (true) {
            System.out.println("Начать новую игру? (1 - да, другое - выход)");

            if (!scanner.nextLine().equals("1")) {
                System.out.println("Выход из игры.");
                break;
            }

            playGame();
        }
    }

    private void playGame() {

        HangmanRenderer renderer = new HangmanRenderer();
        Game game = new Game(wordService.getRandomWord(), 6);

        while (game.getStatus() == GameStatus.IN_PROGRESS) {
            int errorsCount = 6 - game.getRemainingAttempts();

            System.out.println(renderer.getStage(errorsCount));
            System.out.println("\nСлово: " + game.getMaskedWord());
            System.out.println("Ошибки: " + game.getWrongLetters());
            System.out.println("Осталось попыток: " + game.getRemainingAttempts());

            System.out.print("Введите букву: ");
            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Введите ОДНУ букву!");
                continue;
            }

            char letter = input.charAt(0);

            boolean correct = game.guess(letter);

            if (!correct) {
                System.out.println("Неверно!");
            }
        }

        if (game.getStatus() == GameStatus.WON) {
            System.out.println("  Вы выиграли! Слово: " + game.getWord());
        } else {
            System.out.println("  Вы проиграли! Слово: " + game.getWord());
        }
    }
}



