package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Exercise 25 — HashMap (student ID -> name)
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students? ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Name: ");
            students.put(id, sc.nextLine());
        }

        System.out.print("\nLook up ID: ");
        int query = Integer.parseInt(sc.nextLine().trim());
        System.out.println(students.getOrDefault(query, "No student with that ID."));
    }
}
