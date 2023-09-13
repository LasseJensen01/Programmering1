package Ex02;

import java.util.ArrayList;

public class Rental {
    private int no;
    private String date;
    private int days; //days of rental
    private ArrayList<Car> cars = new ArrayList<>(); // Link --> 0..* Car

    public Rental(int no, String date, int days){
        this.no = no;
        this.date = date;
        this.days = days;
    }

    public int getNo() {
        return no;
    }

    public String getDate() {
        return date;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
    public int getPrice(Car car){
        return car.getPricePerDay() * getDays();
    }
    public void addCar(Car car){
        cars.add(car);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "no=" + no +
                ", date='" + date + '\'' +
                ", days=" + days +
                ", cars=" + cars +
                '}';
    }
}
