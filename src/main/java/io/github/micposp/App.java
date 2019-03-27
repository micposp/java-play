package io.github.micposp;

public class App {
    public static void main(String[] args) {
        Menu mainMenu = new MainMenu(new DbWorker());
        mainMenu.printMenu();
        mainMenu.interactWithMenu();
    }
}
