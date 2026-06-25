package io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Exercise 22 — File Writing
public class FileWriteDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to save: ");
        String text = sc.nextLine();
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(text);
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            System.out.println("Write failed: " + e.getMessage());
        }
    }
}
