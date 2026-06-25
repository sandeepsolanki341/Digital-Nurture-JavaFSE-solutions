package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Exercise 24 — ArrayList
public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter names (blank line to stop):");
        String input;
        while (!(input = sc.nextLine()).isBlank()) {
            names.add(input);
        }
        System.out.println("\nNames entered:");
        names.forEach(System.out::println);
    }
}
