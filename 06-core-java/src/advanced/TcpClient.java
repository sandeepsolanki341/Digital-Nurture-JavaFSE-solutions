package advanced;

import java.io.*;
import java.net.*;

// Exercise 35 — TCP Client (run after TcpServer is listening)
public class TcpClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(
                     new InputStreamReader(System.in))) {

            System.out.println("Connected. Type messages ('bye' to quit):");
            String userLine;
            while ((userLine = console.readLine()) != null) {
                out.println(userLine);
                System.out.println(in.readLine());
                if ("bye".equalsIgnoreCase(userLine)) break;
            }
        }
    }
}
