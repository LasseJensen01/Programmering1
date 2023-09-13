package storage;

import model.Bane;
import model.Kategori;
import model.Spiller;

import java.util.ArrayList;

public abstract class Storage {
    private static final ArrayList<Spiller> spillere = new ArrayList<>();
    private static final ArrayList<Bane> baner = new ArrayList<>();
    private static final ArrayList<Kategori> kategorier = new ArrayList<>();

    public static void addSpiller(Spiller spiller){
        spillere.add(spiller);
    }

    public static ArrayList<Spiller> getSpillere() {
        return new ArrayList<>(spillere);
    }

    public static void addBane(Bane bane){
        baner.add(bane);
    }

    public static ArrayList<Bane> getBaner() {
        return new ArrayList<>(baner);
    }

    public static void addKategori(Kategori kategori){
        kategorier.add(kategori);
    }
}
