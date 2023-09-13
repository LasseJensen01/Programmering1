package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {
    private int nummer;
    private boolean inde;
    private LocalTime førsteTid;
    private LocalTime sidsteTid;
    private final ArrayList<Booking> bookinger = new ArrayList<>();
    private final Kategori kategori;

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
    }

    //S2 (5 Point)
    public int bookedeTimerPåDato(LocalDate dato){
        int sum = 0;
        ArrayList<Booking> bookings = new ArrayList<>(bookinger);
        for (Booking b : bookings){
            if (b.getDato().equals(dato)){
                sum++;
            }
        }
        return sum;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void addBooking(Booking booking){
        bookinger.add(booking);
    }

    public ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    //S4 (8 point)
    /*


    public int[] antalBookningerPrTime(){
        int åbningsTime = sidsteTid.getHour();
        int antalÅbneTimer = åbningsTime - førsteTid.getHour();
        int[] bookingsPrTime = new int[antalÅbneTimer];
        ArrayList<Booking> bookings = new ArrayList(bookinger);
        for (int i = 0; i < bookingsPrTime.length;i++){
            bookingsPrTime[i] = 0;
        }
        for (int i = 0; i < bookings.size();i++){
            int tid = bookings.get(i).getTid().getHour();
            bookingsPrTime[tid - 9] = 1;
        }
        return bookingsPrTime;
    }

     */


    //S8 (4 point)
    public boolean tidLedig(LocalDate dato, LocalTime tid){
        ArrayList<Booking> bookings = new ArrayList<>(bookinger);
        boolean notfound = true;
        boolean erLedig = true;
        //Hvis en bane ikke har nogen bookings endnu
        if (bookings.isEmpty()){
            notfound = false;
        }
        int count = 0;
        while (notfound){
            if (bookings.get(count).getDato().equals(dato) && bookings.get(count).getTid().equals(tid)){
                notfound = false;
                erLedig = false;
            }
            count++;
            if (count > bookings.size()){
                notfound = false;
            }
        }
        return erLedig;
    }

    public int getNummer() {
        return nummer;
    }

    @Override
    public String toString() {
        String type = "";
        if (inde){
            type = "inde";
        } else{
            type = "ude";
        }
        return "Nr." + nummer + " " + type + " (" + førsteTid + "->" + sidsteTid + "), " + kategori.getNavn();
    }
}
