package oop;

// Exercise 18 — Inheritance
class Animal {
    void makeSound() { System.out.println("Some generic sound"); }
}

class Dog extends Animal {
    @Override
    void makeSound() { System.out.println("Bark"); }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        new Animal().makeSound();
        new Dog().makeSound();
    }
}
