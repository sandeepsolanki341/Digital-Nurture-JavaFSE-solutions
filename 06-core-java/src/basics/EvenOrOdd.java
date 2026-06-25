package basics;

import java.util.Scanner;

// Exercise 3 — Even or Odd Checker
public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        System.out.println(n + " is " + (n % 2 == 0 ? "even" : "odd"));
    }
}
