package storage;

import model.Fag;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Fag> fag = new ArrayList<>();
    public static void addFag(Fag f){
        fag.add(f);
    }

    public static ArrayList<Fag> getFag() {
        return new ArrayList<>(fag);
    }
}
