package jdbc;

import java.sql.*;

// Exercise 33 — Transaction Handling (money transfer)
//   CREATE TABLE accounts (acc_id INT PRIMARY KEY, balance DECIMAL(10,2));
public class TransactionDemo {
    static final String URL  = "jdbc:mysql://localhost:3306/event_portal";
    static final String USER = "root";
    static final String PASS = "password";

    static void transfer(int fromAcc, int toAcc, double amount) {
        String debit  = "UPDATE accounts SET balance = balance - ? WHERE acc_id = ?";
        String credit = "UPDATE accounts SET balance = balance + ? WHERE acc_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {
            conn.setAutoCommit(false);
            try (PreparedStatement d = conn.prepareStatement(debit);
                 PreparedStatement c = conn.prepareStatement(credit)) {

                d.setDouble(1, amount); d.setInt(2, fromAcc); d.executeUpdate();
                c.setDouble(1, amount); c.setInt(2, toAcc);   c.executeUpdate();

                conn.commit();
                System.out.println("Transfer committed.");
            } catch (SQLException ex) {
                conn.rollback();
                System.out.println("Transfer rolled back: " + ex.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("DB error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        transfer(1, 2, 500.00);
    }
}
