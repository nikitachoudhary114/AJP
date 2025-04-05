import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class delete {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "Choudhary123";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

            // Update values in the table
            String updateSQL = "DELETE FROM users WHERE name = 'Nikita'";
            Statement stmt = conn.createStatement();
            int rowsAffected = stmt.executeUpdate(updateSQL);
            System.out.println(rowsAffected + " row(s) deleted successfully!");

            // Close connection
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            e.printStackTrace();
        }
    }
}