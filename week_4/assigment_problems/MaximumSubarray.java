package week_4.assigment_problems;

import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int current = nums[0];
        int maximum = nums[0];

        for (int i = 1; i < n; i++) {

            current = Math.max(nums[i], current + nums[i]);

            if (current > maximum) {
                maximum = current;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maximum);
    }
}