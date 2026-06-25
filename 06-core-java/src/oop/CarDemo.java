package oop;

// Exercise 17 — Class and Object Creation
class Car {
    String make, model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayDetails() {
        System.out.println(year + " " + make + " " + model);
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car c1 = new Car("Toyota", "Corolla", 2022);
        Car c2 = new Car("Tesla", "Model 3", 2024);
        c1.displayDetails();
        c2.displayDetails();
    }
}
