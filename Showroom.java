// public class Showroom {
//     Car[] cars;
//     Showroom(){
//         cars = new Car[10];
//         cars[0] = new Car(1, "Maruti", "Swift", 1500);
//         cars[1] = new Car(2, "Hyundai", "Creta", 2500);
//         cars[2] = new Car(3, "Tata", "Nexon", 2000);
//         cars[3] = new Car(4, "Toyota", "Fortuner", 5000);
//         cars[4] = new Car(5, "Mahindra", "Thar", 3000);
//         cars[5] = new Car(6, "Honda", "City", 2200);
//         cars[6] = new Car(7, "Kia", "Seltos", 2400);
//         cars[7] = new Car(8, "BMW", "X1", 6000);
//         cars[8] = new Car(9, "Audi", "A4", 7000);
//         cars[9] = new Car(10, "Mercedes", "C-class", 8000);
//     }
//     void showCars(){
//         for(int i=0; i<cars.length;i++){
//             System.out.println(cars[i].carId + " | "
//                 +cars[i].company+ " | "
//                 +cars[i].model + " | ₹"
//                 +cars[i].pricePerDay+ " | "
//                 +(cars[i].available? "Avilable" : "Rentad")
//             );
//         }
//     }
//     Car findCar(int id){
//         for(int i=0;i<cars.length;i++){
//             if(cars[i].carId==id){
//                 return cars[i];
//             }
//         }
//         return null;
//     }
// }
  




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Showroom {

    Car[] cars;

    Showroom() {

        cars = new Car[10];

        cars[0] = new Car(1, "Maruti", "Swift", 1500);
        cars[1] = new Car(2, "Hyundai", "Creta", 2500);
        cars[2] = new Car(3, "Tata", "Nexon", 2000);
        cars[3] = new Car(4, "Toyota", "Fortuner", 5000);
        cars[4] = new Car(5, "Mahindra", "Thar", 3000);
        cars[5] = new Car(6, "Honda", "City", 2200);
        cars[6] = new Car(7, "Kia", "Seltos", 2400);
        cars[7] = new Car(8, "BMW", "X1", 6000);
        cars[8] = new Car(9, "Audi", "A4", 7000);
        cars[9] = new Car(10, "Mercedes", "C-class", 8000);

        loadAvailability();
    }

    void loadAvailability() {

        String sql = "SELECT car_id, available FROM cars";

        try {

            Connection con = DataBaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("car_id");
                boolean available = rs.getBoolean("available");

                for (int i = 0; i < cars.length; i++) {

                    if (cars[i].carId == id) {

                        cars[i].available = available;
                        break;
                    }
                }
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    void showCars() {

        for (int i = 0; i < cars.length; i++) {

            System.out.println(
                cars[i].carId + " | "
                + cars[i].company + " | "
                + cars[i].model + " | ₹"
                + cars[i].pricePerDay + " | "
                + (cars[i].available ? "Available" : "Rented")
            );
        }
    }

    Car findCar(int id) {

        for (int i = 0; i < cars.length; i++) {

            if (cars[i].carId == id) {

                return cars[i];
            }
        }

        return null;
    }
}