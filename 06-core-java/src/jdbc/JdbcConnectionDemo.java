package jdbc;

import java.sql.*;

// Exercise 31 — Basic JDBC Connection (SELECT from students)
// Requires MySQL Connector/J on the classpath and a `students` table.
//   CREATE TABLE students (id INT PRIMARY KEY, name VARCHAR(100), grade VARCHAR(2));
public class JdbcConnectionDemo {
    static final String URL  = "jdbc:mysql://localhost:3306/event_portal";
    static final String USER = "root";
    static final String PASS = "password";   // replace with your credentials

    public static void main(String[] args) {
        String sql = "SELECT id, name, grade FROM students";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("ID | Name | Grade");
            while (rs.next()) {
                System.out.printf("%d | %s | %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getString("grade"));
            }
        } catch (SQLException e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }
}
