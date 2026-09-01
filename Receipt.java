public class Receipt {
    void printReceipt(Rental rental){
         System.out.println("==========================");
        System.out.println("     Car Rental System    ");
        System.out.println("==========================");


         System.out.println("Costomer : " + rental.user.name);
         System.out.println("Car : "+ rental.car.company);
         System.out.println("Days : "+ rental.days);
         System.out.println("Price/Day : "+ rental.car.pricePerDay);
         System.out.println("Total : "+rental.totalAmount);
         System.out.println("Status : " + "Paid");
         System.out.println("==========================");
    }
}
