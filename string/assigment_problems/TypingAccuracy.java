package string.assigment_problems;

import java.util.Scanner;

public class TypingAccuracy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matched, original.length(), accuracy);

        if (firstMismatch == -1) {
            if (original.length() == typed.length()) {
                System.out.println(" | No Mismatches");
            } else {
                System.out.println(" | Length Mismatch");
            }
        } else {
            System.out.println(" | First Mismatch at position "
                    + (firstMismatch + 1));
        }
    }
}