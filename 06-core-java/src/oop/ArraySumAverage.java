package oop;

import java.util.Scanner;

// Exercise 14 — Array Sum and Average
public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many elements? ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        System.out.println("Sum     = " + sum);
        System.out.printf("Average = %.2f%n", n == 0 ? 0 : (double) sum / n);
    }
}
