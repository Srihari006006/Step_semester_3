package week_9.class_problems;

import java.util.Scanner;

abstract class Connection {
    int units;

    Connection(int units) {
        this.units = units;
    }

    abstract double bill();
}

class Home extends Connection {
    Home(int units) {
        super(units);
    }

    double bill() {
        if (units <= 100)
            return units * 5;
        else
            return 100 * 5 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(int units) {
        super(units);
    }

    double bill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(int units) {
        super(units);
    }

    double bill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("HOME")) {
                connections[i] = new Home(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new Shop(units);
            } else if (type.equals("FACTORY")) {
                connections[i] = new Factory(units);
            }
        }

        for (Connection c : connections) {
            double amount = c.bill();
            System.out.printf("%s: %.2f%n",
                c.getClass().getSimpleName().toUpperCase(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
