package week_9.assigment_problems;

import java.util.Scanner;

interface Insurable {
    double insurance();
}

abstract class Parcel {
    double weight, value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double charge();

    double total() {
        return charge();
    }
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 80 + 15 * weight;
    }

    public double insurance() {
        return value * 0.02;
    }

    double total() {
        return charge() + insurance();
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double charge() {
        return 40 + 10 * weight + 50;
    }

    public double insurance() {
        return value * 0.02;
    }

    double total() {
        return charge() + insurance();
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            if (type.equals("STANDARD"))
                parcels[i] = new Standard(weight, value);
            else if (type.equals("EXPRESS"))
                parcels[i] = new Express(weight, value);
            else if (type.equals("FRAGILE"))
                parcels[i] = new Fragile(weight, value);
        }

        for (Parcel p : parcels) {
            double insurance = 0;

            if (p instanceof Insurable)
                insurance = ((Insurable) p).insurance();

            double total = p.charge() + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                p.getClass().getSimpleName().toUpperCase(),
                p.charge(), insurance, total);

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
