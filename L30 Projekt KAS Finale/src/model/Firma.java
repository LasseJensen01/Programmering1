package model;

import java.util.ArrayList;

public class Firma {
    private String navn;
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Firma(String navn, String tlf){
        this.navn = navn;
    }
    public void addTilmelding(Tilmelding t){
        tilmeldinger.add(t);
    }

    @Override
    public String toString() {
        return "" + navn;
    }
}
