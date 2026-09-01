public class Rental {
    Car car;
    User user;
    int days;
    double totalAmount;
    Rental( Car car, User user,int days){
        this.car=car;
        this.user=user;
        this.days=days;
        this.totalAmount=car.pricePerDay*days;
        car.available=false;
    }
}
