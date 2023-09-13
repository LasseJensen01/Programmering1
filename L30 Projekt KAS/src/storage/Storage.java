package storage;

import model.Deltager;
import model.Firma;
import model.Hotel;
import model.Konference;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Firma> firmaer = new ArrayList<>();

    public static void addKonference(Konference k){
        konferencer.add(k);
    }
    public static ArrayList getKonference(){
        return new ArrayList(konferencer);
    }
    public static void addHotel(Hotel h){
        hoteller.add(h);
    }
    public static ArrayList getHoteller(){
        return new ArrayList(hoteller);
    }
    public static void addDeltager(Deltager d){
        deltagere.add(d);
    }
    public static ArrayList getDeltagere(){
        return new ArrayList<>(deltagere);
    }
    public static void addFirma(Firma f){
        firmaer.add(f);
    }
    public static ArrayList getFirmaer(){
        return new ArrayList(firmaer);
    }
}
