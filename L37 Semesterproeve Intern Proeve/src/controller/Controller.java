package controller;

import model.Bane;
import model.Booking;
import model.Kategori;
import model.Spiller;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class Controller {

    public static Spiller createSpiller(String navn, String uddannelse){
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.addSpiller(spiller);
        return spiller;
    }

    public static Booking createBooking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane){
        Booking booking = new Booking(dato,tid,single,spiller,bane);
        spiller.addBooking(booking);
        bane.addBooking(booking);
        return booking;
    }

    public static Bane createBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori){
        Bane bane = new Bane(nummer,inde,førsteTid,sidsteTid,kategori);
        Storage.addBane(bane);
        return bane;
    }

    public static Kategori createKategori(String navn, int prisKrSingle, int prisKrDouble){
        Kategori kategori = new Kategori(navn,prisKrSingle,prisKrDouble);
        Storage.addKategori(kategori);
        return kategori;
    }

    //S7 (8 point)
    public static int samletBooketDoubleTid(String Uddannelse, Kategori kategori){
        int sum = 0;
        ArrayList<Spiller> spillere = new ArrayList<>(Storage.getSpillere());
        for (Spiller s : spillere){
            if (s.getUddannelse().equals(Uddannelse)){
                ArrayList<Booking> bookinger = new ArrayList<>(s.getBookinger());
                for (Booking b : bookinger){
                    if (!b.isSingle() && b.getBane().getKategori().equals(kategori)){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
    //S9 (5 point)
    public static Bane findLedigBane(LocalDate dato, LocalTime tid, Kategori kategori){
        ArrayList<Bane> baner = new ArrayList<>(Storage.getBaner());
        boolean notfound = true;
        Bane ledigBane = null;
        int count = 0;
        while (notfound){
            if (baner.get(count).getKategori().equals(kategori) && baner.get(count).tidLedig(dato,tid)){
                notfound = false;
                ledigBane = baner.get(count);
            }
            else{
                count++;
                if (count > baner.size()){
                    notfound = false;
                }
            }
        }
        return ledigBane;
    }

    //S10 (7 point)
    public static void udskrivBookingsAfBaner(String filNavn){
        ArrayList<Bane> baner = new ArrayList<>(Storage.getBaner());
        String filePath = "L37 Semesterproeve Intern Proeve/src/controller/";
        filePath += filNavn;
        File fil = new File(filePath);
        try(PrintWriter writer = new PrintWriter(fil)){
            for (Bane b : baner){
                ArrayList<Booking> bookings = new ArrayList<>(b.getBookinger());
                if (!bookings.isEmpty()){
                    for (Booking booking : bookings){
                        writer.println(booking.toString());
                    }
                }
            }
        }
        catch (FileNotFoundException ex){
            System.err.println("File not found " + ex.getMessage());
        }
    }

    public static ArrayList<Bane> getBaner(){
        return Storage.getBaner();
    }
    public static ArrayList<Spiller> getSpillere(){
        return Storage.getSpillere();
    }
}
