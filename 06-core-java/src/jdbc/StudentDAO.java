package jdbc;

import java.sql.*;

// Exercise 32 — Insert and Update via JDBC using PreparedStatement
public class StudentDAO {
    private final String url, user, pass;

    public StudentDAO(String url, String user, String pass) {
        this.url = url; this.user = user; this.pass = pass;
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }

    public void insertStudent(int id, String name, String grade) throws SQLException {
        String sql = "INSERT INTO students (id, name, grade) VALUES (?, ?, ?)";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, grade);
            System.out.println(ps.executeUpdate() + " row(s) inserted.");
        }
    }

    public void updateGrade(int id, String newGrade) throws SQLException {
        String sql = "UPDATE students SET grade = ? WHERE id = ?";
        try (Connection c = connect(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, newGrade);
            ps.setInt(2, id);
            System.out.println(ps.executeUpdate() + " row(s) updated.");
        }
    }

    public static void main(String[] args) throws SQLException {
        StudentDAO dao = new StudentDAO(
            "jdbc:mysql://localhost:3306/event_portal", "root", "password");
        dao.insertStudent(101, "Grace Hopper", "A");
        dao.updateGrade(101, "A+");
    }
}
