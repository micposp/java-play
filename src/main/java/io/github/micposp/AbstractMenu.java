package io.github.micposp;
import io.github.micposp.*;
import java.util.*;

public abstract class AbstractMenu implements Menu {
    protected List<String> items;
    protected String MENU_HEADER = "Please select menu item";

    public AbstractMenu() {
        this.items = new ArrayList<>();
    }

    private void printMenuHeader() {
        System.out.println(MENU_HEADER);
    }

    @Override
    public void printMenu() {
        printMenuHeader();

        for (int i = 1; i <= items.size(); i++) {
            StringBuilder printableMenuItem = new StringBuilder()
                    .append(i)
                    .append(" - ")
                    .append(items.get( i - 1 ));
            System.out.println(printableMenuItem.toString());
        }
    }
}
