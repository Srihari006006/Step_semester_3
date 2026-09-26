package week_8.class_problems;

import java.util.*;

abstract class Transport {
    double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculate();
}

class Bus extends Transport {
    Bus(double distance) {
        super(distance);
    }

    double calculate() {
        double fare = 2 + (0.1 * distance);

        if (fare > 10)
            fare = 10;

        return fare;
    }
}

class Train extends Transport {
    Train(double distance) {
        super(distance);
    }

    double calculate() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {
    double factor;

    Metro(double distance, double factor) {
        super(distance);
        this.factor = factor;
    }

    double calculate() {
        return (1.5 + (0.2 * distance)) * factor;
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport t;

            if (type.equals("BUS"))
                t = new Bus(distance);
            else if (type.equals("TRAIN"))
                t = new Train(distance);
            else {
                double factor = sc.nextDouble();
                t = new Metro(distance, factor);
            }

            double fare = t.calculate();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}