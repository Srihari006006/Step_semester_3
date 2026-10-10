package week_9.assigment_problems;

import java.util.Scanner;

interface NightService {
    double nightFare(double fare);
}

abstract class Cab {
    double km;
    static final double MIN_FARE = 100;

    Cab(double km) {
        this.km = km;
    }

    abstract double fare();

    double finalFare() {
        return Math.max(fare(), MIN_FARE);
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double fare() {
        return km * 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double fare() {
        return km * 14;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double fare() {
        return km * 18;
    }

    public double nightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI"))
                cab = new Mini(km);
            else if (type.equals("SEDAN"))
                cab = new Sedan(km);
            else
                cab = new SUV(km);

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println("MINI: night service not available");
                continue;
            }

            double amount = cab.finalFare();

            if (time.equals("NIGHT"))
                amount = ((NightService) cab).nightFare(amount);

            System.out.printf("%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
