public class Car {
    int carId;
    String company;
    String model;
    double pricePerDay;
    boolean available;
    Car(int carId, String company, String model, double pricePerDay){
        this.carId=carId;
        this.company=company;
        this.model=model;
        this.pricePerDay=pricePerDay;
        this.available=true;
    }
}
