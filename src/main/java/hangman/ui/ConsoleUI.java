package hangman.ui;


import hangman.game.*;

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

    private Difficulty chooseDifficulty() {
        System.out.println("Выберите сложность:");
        System.out.println("1 - Легко (8 попыток)");
        System.out.println("2 - Средне (6 попыток)");
        System.out.println("3 - Сложно (4 попытки)");

        String input = scanner.nextLine();

        return switch (input) {
            case "1" -> Difficulty.EASY;
            case "2" -> Difficulty.MEDIUM;
            case "3" -> Difficulty.HARD;
            default -> {
                System.out.println("Неверный ввод, выбрана средняя сложность.");
                yield Difficulty.MEDIUM;
            }
        };
    }

    private void playGame() {

        Difficulty difficulty = chooseDifficulty();
        HangmanRenderer renderer = new HangmanRenderer();
        System.out.println("Выбрана сложность: " + difficulty);

        Game game = new Game(
                wordService.getRandomWord(),
                difficulty.getMaxErrors()
        );

        while (game.getStatus() == GameStatus.IN_PROGRESS) {

            System.out.println("\nСлово: " + game.getMaskedWord());
            System.out.println("Ошибки: " + game.getWrongLetters());
            System.out.println("Осталось попыток: " + game.getRemainingAttempts());

            System.out.print("Введите букву: ");
            String input = scanner.nextLine();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Введите ОДНУ букву!");
                continue;
            }

            char letter = input.charAt(0);

            GuessResult result = game.guess(letter);
            int errorsCount = 6 - game.getRemainingAttempts();

            switch (result) {
                case WRONG -> System.out.println("Неверно!");
                case ALREADY_GUESSED -> System.out.println("Эта буква уже была!");
                case CORRECT -> System.out.println("Верно!");
            }
            System.out.println(renderer.getStage(errorsCount));


        }

        if (game.getStatus() == GameStatus.WON) {
            System.out.println("  Вы выиграли! Слово: " + game.getWord());
        } else {
            System.out.println("  Вы проиграли! Слово: " + game.getWord());
        }
    }

}



