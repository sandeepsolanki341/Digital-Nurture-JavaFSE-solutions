package advanced;

import java.lang.reflect.Method;

// Exercise 39 — Reflection API
public class ReflectionDemo {
    static class Calculator {
        public int square(int n) { return n * n; }
        public String greet(String name) { return "Hello, " + name; }
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("advanced.ReflectionDemo$Calculator");
        System.out.println("Declared methods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("  " + m.getName() + " -> " + m.getReturnType().getSimpleName());
        }

        Object instance = clazz.getDeclaredConstructor().newInstance();
        Method square = clazz.getMethod("square", int.class);
        Object result = square.invoke(instance, 7);
        System.out.println("Invoked square(7) = " + result);
    }
}
