import java.sql.Connection;
import java.sql.PreparedStatement;

public class RentalDAO {

    public static void saveRental(Rental rental) {

        String sql = """
                INSERT INTO rentals
                (user_name, phone, id_number, address,
                 license_number, car_id, company, model,
                 days, price_per_day, total_amount, rental_date)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURDATE())
                """;

        try {

            Connection con = DataBaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, rental.user.name);
            ps.setString(2, rental.user.phoneNumber);
            ps.setString(3, rental.user.idNumber);
            ps.setString(4, rental.user.address);
            ps.setString(5, rental.user.licenseNumber);

            ps.setInt(6, rental.car.carId);
            ps.setString(7, rental.car.company);
            ps.setString(8, rental.car.model);

            ps.setInt(9, rental.days);
            ps.setDouble(10, rental.car.pricePerDay);
            ps.setDouble(11, rental.totalAmount);

            ps.executeUpdate();


            String updateCar = 
            "UPDATE cars SET available = false WHERE car_id = ?";

         PreparedStatement ps2 = con.prepareStatement(updateCar);

           ps2.setInt(1, rental.car.carId);

          ps2.executeUpdate();

          ps2.close();

            // System.out.println("Rental details saved in MySQL!");

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        
    }
    public static void returnCar(int carId) {

    String sql = "UPDATE cars SET available = true WHERE car_id = ?";

    try {

        Connection con = DataBaseConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, carId);

        ps.executeUpdate();

        ps.close();
        con.close();

        // System.out.println("Car availability updated in MySQL!");

    } catch (Exception e) {

        e.printStackTrace();
    }
}
     public static void updateRentalStatus(int carId) {

    String sql = """
            UPDATE rentals
            SET status = 'RETURNED'
            WHERE car_id = ?
            AND status = 'RENTED'
            """;

    try {

        Connection con = DataBaseConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, carId);

        ps.executeUpdate();

        ps.close();
        con.close();

        // System.out.println("Rental status updated to RETURNED!");

    } catch (Exception e) {

        e.printStackTrace();
    }
}
}