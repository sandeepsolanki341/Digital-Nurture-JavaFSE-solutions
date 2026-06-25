package advanced;

import java.io.*;
import java.net.*;

// Exercise 35 — TCP Server (run first, then TcpClient in another terminal)
public class TcpServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(5000)) {
            System.out.println("Server listening on port 5000...");
            try (Socket socket = server.accept();
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                System.out.println("Client connected.");
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("Client: " + line);
                    out.println("Echo: " + line);
                    if ("bye".equalsIgnoreCase(line)) break;
                }
            }
        }
    }
}
