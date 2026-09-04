package week_4.assigment_problems;

import java.util.Scanner;

public class ProductExceptSelf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int product = 1;

        for (int i = 0; i < n; i++) {
            result[i] = product;
            product = product * nums[i];
        }

        product = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * nums[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}