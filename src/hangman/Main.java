package hangman;

import hangman.ui.ConsoleUI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}
