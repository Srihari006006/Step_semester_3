package week_8.class_problems;

import java.util.*;
import java.util.regex.*;

abstract class Question {
    String correct;
    String student;
    double points;

    Question(String correct, String student, double points) {
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract double grade();
}

class MCQ extends Question {
    MCQ(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        return correct.equalsIgnoreCase(student) ? points : 0;
    }
}

class TF extends Question {
    TF(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        return correct.equalsIgnoreCase(student) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String correct, String student, double points) {
        super(correct, student, points);
    }

    double grade() {
        String[] keywords = correct.split(",");
        int count = 0;

        for (String key : keywords) {
            if (student.toLowerCase().contains(key.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2)
            return points * 0.75;
        else if (count == 1)
            return points * 0.50;
        else
            return 0;
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));

            Matcher m = Pattern.compile("\"([^\"]*)\"").matcher(line);

            String[] data = new String[3];
            int j = 0;

            while (m.find()) {
                data[j++] = m.group(1);
            }

            String[] parts = line.trim().split(" ");
            double points = Double.parseDouble(parts[parts.length - 1]);

            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(data[1], data[2], points);
            else if (type.equals("TF"))
                q = new TF(data[1], data[2], points);
            else
                q = new Essay(data[1], data[2], points);

            double score = q.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}