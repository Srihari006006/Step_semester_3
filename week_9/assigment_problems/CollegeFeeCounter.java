package week_9.assigment_problems;

import java.util.Scanner;

abstract class Student {
    String name;
    static final double BUS_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double fee();
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double fee() {
        return 40000 + BUS_FEE;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double fee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double fee() {
        return 20000 + BUS_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR"))
                students[i] = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                students[i] = new Hosteller(name);
            else if (type.equals("SCHOLAR"))
                students[i] = new Scholar(name);
        }

        for (Student s : students) {
            double amount = s.fee();
            System.out.printf("%s: %.2f%n", s.name, amount);
            total += amount;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
