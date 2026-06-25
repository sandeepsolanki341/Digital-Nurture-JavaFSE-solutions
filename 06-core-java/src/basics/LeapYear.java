package basics;

import java.util.Scanner;

// Exercise 4 — Leap Year Checker
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int y = sc.nextInt();
        boolean leap = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
        System.out.println(y + (leap ? " is" : " is not") + " a leap year.");
    }
}
