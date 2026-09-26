package week_8.class_problems;

import java.util.*;
import java.time.*;

abstract class Item {
    String title;
    LocalDate date;

    Item(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    abstract int days();
}

class Book extends Item {
    Book(String title, LocalDate date) {
        super(title, date);
    }

    int days() {
        return 14;
    }
}

class DVD extends Item {
    DVD(String title, LocalDate date) {
        super(title, date);
    }

    int days() {
        return 7;
    }
}

class Magazine extends Item {
    Magazine(String title, LocalDate date) {
        super(title, date);
    }

    int days() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");

            Item item;

            if (type.equals("BOOK"))
                item = new Book(title, currentDate);
            else if (type.equals("DVD"))
                item = new DVD(title, currentDate);
            else
                item = new Magazine(title, currentDate);

            LocalDate dueDate = currentDate.plusDays(item.days());

            System.out.println(title + ": " + dueDate);
        }
    }
}