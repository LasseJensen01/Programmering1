package storage;

import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.util.ArrayList;

public abstract class Storage {
    private final static ArrayList<Forestilling> forestillings = new ArrayList<>();
    private final static ArrayList<Plads> pladser = new ArrayList<>();
    private final static ArrayList<Kunde> kundes = new ArrayList<>();

    public static ArrayList<Plads> getPlads() {
        return new ArrayList<>(pladser);
    }

    public static ArrayList<Kunde> getKundes() {
        return new ArrayList<>(kundes);
    }

    public static ArrayList<Forestilling> getForestillings() {
        return new ArrayList<>(forestillings);
    }
    public static void addKunde(Kunde kunde){
        kundes.add(kunde);
    }
    public static void addForestilling(Forestilling forestilling){
        forestillings.add(forestilling);
    }
    public static void addPlads(Plads plads){
        pladser.add(plads);
    }
}
