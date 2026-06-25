package basics;

import java.util.Random;
import java.util.Scanner;

// Exercise 10 — Number Guessing Game (1-100)
public class NumberGuessing {
    public static void main(String[] args) {
        int target = new Random().nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int guess, attempts = 0;

        System.out.println("Guess a number between 1 and 100.");
        do {
            System.out.print("Your guess: ");
            guess = sc.nextInt();
            attempts++;
            if (guess > target)      System.out.println("Too high.");
            else if (guess < target) System.out.println("Too low.");
        } while (guess != target);

        System.out.println("Correct! Solved in " + attempts + " attempts.");
    }
}
