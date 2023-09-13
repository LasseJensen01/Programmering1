package E01CarApp;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White", "AB 12.345", 50000);
        System.out.println("Test: " + myCar.toString());
        System.out.println();

        // String brand = myCar.brand;
        System.out.println("Brand " + myCar.brand);
        System.out.println("My car: " + myCar.brand + ", " + myCar.color);

        myCar.km = 65000;
        System.out.println("Km nu: " + myCar.km);

        // Assignment 1
        System.out.println();
        Car myCar2 = new Car("Suzuki Alto", "Grey","CN 69.420");
        System.out.println("Test: " + myCar2.toString());
        System.out.println("Brand: " + myCar2.brand);
        System.out.println("My Car2: " + myCar2.brand + ", " + myCar2.color);
        myCar2.km = 250000;
        System.out.println("Km nu: " + myCar2.km);

        System.out.println();

        System.out.println("****************");
        System.out.println("* " + myCar2.brand);
        System.out.println("* " + myCar2.regNo);
        System.out.println("* " + myCar2.km + " km");
        System.out.println("****************");
    }
}
