package oop;

import java.util.Scanner;

// Exercise 16 — Palindrome Checker
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String raw = sc.nextLine();
        String cleaned = raw.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        boolean palindrome = cleaned.equals(reversed);
        System.out.println("\"" + raw + "\" is " + (palindrome ? "" : "not ") + "a palindrome.");
    }
}
