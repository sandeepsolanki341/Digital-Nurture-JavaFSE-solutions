package modern;

import java.util.List;

// Exercise 29 — Records (Java 16+)
public class RecordDemo {
    record Person(String name, int age) {}

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 17),
            new Person("Charlie", 25)
        );

        System.out.println("All people: " + people);
        System.out.println("\nAdults (age >= 18):");
        people.stream()
              .filter(p -> p.age() >= 18)
              .forEach(System.out::println);
    }
}
