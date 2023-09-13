package Ex02;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Car {
    private String no;
    private String year;
    private int pricePerDay;
    private ArrayList<Rental> rental = new ArrayList<>(); // Link --> 0..* Rental

    public Car(String no, String year){
        this.no = no;
        this.year = year;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public String getNo() {
        return no;
    }

    public String getYear() {
        return year;
    }
    public int maxDaysCarRented(){
        int max = 0;
        for (int i = 0; i < rental.size(); i++){
            if ( max < rental.get(i).getDays()){
                max = rental.get(i).getDays();
            }
        }
        return max;
    }
    public void addRental(Rental rental){
        this.rental.add(rental);
        rental.addCar(this);
    }

    @Override
    public String toString() {
        return "Car{" +
                "no='" + no + '\'' +
                ", year='" + year + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", rental=" + rental +
                '}';
    }
}
