package E01CarApp;

public class Car {
    String brand;
    String color;
    String regNo; // registration number
    int km;

    public Car(String brand, String color, String regNo, int km) {
        this.brand = brand;
        this.color = color;
        this.regNo = regNo;
        this.km = km;
    }
    public Car(String brand, String color, String regNo){
        this(brand,color,regNo,0);
    }
    @Override
    public String toString() {
        return String.format("Car(%s, %s, %s, %d km)", brand, color, regNo, km);
    }
}
