import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/car_rental_db";
        String username = "root";
        String password = "Deepak@121";

        try {

            Connection con = DriverManager.getConnection(
                url,
                username,
                password
            );

            // System.out.println("Database Connected!");

            return con;

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
}