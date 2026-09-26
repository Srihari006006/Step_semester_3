package week_8.assigment_problems;

import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    String name;
    LocalDate date;

    Plan(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    abstract int days();
}

class Basic extends Plan {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int days() {
        return 30;
    }
}

class Standard extends Plan {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int days() {
        return 90;
    }
}

class Premium extends Plan {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int days() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(name, date);
            else if (type.equals("STANDARD"))
                p = new Standard(name, date);
            else
                p = new Premium(name, date);

            LocalDate renewal = date.plusDays(p.days());

            System.out.println(name + ": " + renewal);
        }
    }
}