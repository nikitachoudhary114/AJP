import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "Choudhary123";

        try {
            // Load MySQL JDBC Driver
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
                System.out.println("JDBC Driver not found!");
                e.printStackTrace();
                return;
            }

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!");

            // Close connection
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Database connection failed!");
            e.printStackTrace();
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}
