package io.github.micposp;
//import io.github.micposp.*;
//import java.util.Scanner;
import java.util.*;
import java.io.*;

public class MainMenu extends AbstractMenu {
    private DbWorker dbWorker;

    public MainMenu(DbWorker dbWorker) {
        super();
        initMenuItems();
        this.dbWorker=dbWorker;
    }

    private void initMenuItems() {
        this.items.add("Create");
        this.items.add("Search");
        this.items.add("Sort");
    }

    @Override
    public void interactWithMenu() {
        int choice=0;

        while (true) {
            choice=this.getChoice();

            switch (choice) {
                case 1:
                    this.Create();
                    break;
                case 2:
                    this.Search();
                    break;
                case 3:
                    this.Sort();
                    break;
            }

            this.printMenu();
        }
    }

    private int getChoice() {
        Scanner in = new Scanner(System.in);
        int choice=0;

        while (true) {
            System.out.print("Choose item: ");

            try {
                choice = in.nextInt();
                if (choice < 1 || choice > this.items.size()) {
                    throw new MainMenu.InputOutOfBand();
                }
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Incorrect choice format");
                in.nextLine();
            }
            catch (InputOutOfBand e) {
                System.out.println("Choice is out of bandwidth");
            }
        }

        return choice;
    }

    private static class InputOutOfBand extends Exception { }

    private void Create() {
        Scanner in = new Scanner(System.in);

        System.out.print("Choose filename: ");
        String filename = in.nextLine();

        this.dbWorker.Create(filename);
    }

    private void Search() {
        this.dbWorker.Search();
    }

    private void Sort() {
        this.dbWorker.Sort();
    }
}
