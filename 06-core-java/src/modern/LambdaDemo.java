package modern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Exercise 27 — Lambda Expressions
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>(List.of("banana", "apple", "cherry", "date"));
        Collections.sort(fruits, (a, b) -> a.compareTo(b));
        System.out.println("Sorted: " + fruits);
    }
}
