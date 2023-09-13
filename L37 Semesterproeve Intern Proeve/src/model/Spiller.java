package model;

import java.util.ArrayList;

public class Spiller {
    private String navn;
    private String uddannelse;
    private final ArrayList<Booking> bookinger = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    //S3 (7 point)
    public int samletPris(Kategori kategori){
        int sum = 0;
        ArrayList<Booking> bookings = new ArrayList<>(bookinger);
        for (Booking b : bookings){
            Kategori k = b.getBane().getKategori();
            if (k.equals(kategori)){
                if (b.isSingle()){
                    sum += k.getPrisKrsingle();
                } else sum += k.getPrisKrDouble();
            }
        }
        return sum;
    }

    public void addBooking(Booking booking){
        bookinger.add(booking);
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn + " (" + uddannelse + ")";
    }
}
