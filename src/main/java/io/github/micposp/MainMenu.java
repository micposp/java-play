package io.github.micposp;
import io.github.micposp.*;
import java.util.Scanner;

public class MainMenu extends AbstractMenu {

    public MainMenu() {
        super();
        initMenuItems();
    }

    private void initMenuItems() {
        this.items.add("Create");
        this.items.add("Search");
        this.items.add("Sort");
    }

    @Override
    public void interactWithMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose item: ");
        while (!in.hasNext()) {
        }
        String item = in.next();
        System.out.println("choice "+item);
    }
}
