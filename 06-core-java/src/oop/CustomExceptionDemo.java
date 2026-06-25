package oop;

import java.util.Scanner;

// Exercise 21 — Custom Exception
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) { super(message); }
}

public class CustomExceptionDemo {
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Age " + age + " is below 18.");
        System.out.println("Access granted.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        try {
            validate(age);
        } catch (InvalidAgeException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
