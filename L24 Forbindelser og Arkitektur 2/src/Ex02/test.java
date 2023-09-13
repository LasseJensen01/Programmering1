package Ex02;

public class test {
    public static void main(String[] args) {
        Car BMW = new Car("C45300", "2001");
        Rental rental = new Rental(1, "190423", 30);
        BMW.setPricePerDay(2);
        BMW.addRental(rental);
        System.out.println(rental.getPrice(BMW));
    }
}
