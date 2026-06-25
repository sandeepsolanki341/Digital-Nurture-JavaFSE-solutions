package oop;

import java.util.Scanner;

// Exercise 15 — String Reversal
public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}
