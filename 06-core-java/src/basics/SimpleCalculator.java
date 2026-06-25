package basics;

import java.util.Scanner;

// Exercise 2 — Simple Calculator (+, -, *, /)
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+ - * /): ");
        String op = sc.next();

        double result;
        switch (op) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> {
                if (b == 0) {
                    System.out.println("Error: division by zero.");
                    return;
                }
                result = a / b;
            }
            default -> {
                System.out.println("Unknown operation.");
                return;
            }
        }
        System.out.println("Result: " + result);
    }
}
