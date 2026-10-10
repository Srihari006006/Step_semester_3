package week_9.class_problems;

import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            if (type.equals("CIRCLE")) {
                plots[i] = new Circle(owner, sc.nextDouble());
            } else if (type.equals("RECTANGLE")) {
                plots[i] = new Rectangle(owner,
                    sc.nextDouble(), sc.nextDouble());
            } else if (type.equals("TRIANGLE")) {
                plots[i] = new Triangle(owner,
                    sc.nextDouble(), sc.nextDouble());
            }
        }

        for (Plot p : plots) {
            System.out.printf("%s (%s): %.2f%n",
                p.owner, p.getClass().getSimpleName().toUpperCase(),
                p.area());
            total += p.area();
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
