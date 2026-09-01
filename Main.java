import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Showroom showroom = new Showroom();
        Receipt receipt = new Receipt();
         
        while(true){
            System.out.println("\n ===== CAR RENTAL SYSTEM =====");
            System.out.println("1. View Car ");
            System.out.println("2. Rent Car ");
            System.out.println("3. Return Car ");
            System.out.println("4. Exit ");
            System.out.print("Enter Choice : ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    showroom.showCars();
                    break;

                    case 2:
                        System.out.print("Enter Car Id :");
                        int carId = sc.nextInt();
                         Car selectedCar = showroom.findCar(carId);
                         if(selectedCar==null){
                            System.out.println("Invalid Car Id");
                            break;
                         }
                         if(!selectedCar.available){
                            System.out.println("Car is currently unavailable");
                            break;
                         }
                        System.out.print("Enter your name: ");
                         String name=sc.next();
                        System.out.print("Enter your age: ");
                         int age=sc.nextInt();
                         System.out.print("Enter your Mobile Number: ");
                         String Mobile = sc.next();
                         System.out.print("Enter AdharId Number: ");
                         String id = sc.next();
                         System.out.print("Enter your address: ");
                         String address = sc.next();
                         System.out.print("Enter License Number: ");
                         String license = sc.next();
                         User user = new User(name, age, Mobile, id, address, license);
                         System.out.print("Enter Rental Days: ");
                         int days = sc.nextInt();
                        Rental rental = new Rental(selectedCar, user, days);
                        RentalDAO.saveRental(rental);
                        receipt.printReceipt(rental);
                        break;

                        case 3:
                            System.out.print("Enter Car id to return: ");
                            int returnId = sc.nextInt();
                            Car returnCar = showroom.findCar(returnId);
                            if(returnCar==null){
                                System.out.println("Invalid Car id ");
                            }else if(returnCar.available){
                                System.out.println("This car is already avialable ");
                            }else{
                                returnCar.available = true;
                                RentalDAO.returnCar(returnId);
                                   RentalDAO.updateRentalStatus(returnId);
                                System.out.println("Car return Successfully ");
                            } 
                            break;

                            case 4:
                                System.out.println("Thank You");
                                sc.close();
                                return;

            
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}  

