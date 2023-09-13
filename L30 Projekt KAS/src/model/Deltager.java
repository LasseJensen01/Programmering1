package model;

import java.util.ArrayList;

public class Deltager {
    private String navn;
    private String tlf;
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    public Deltager(String navn, String tlf){
        this.navn = navn;
        this.tlf = tlf;
    }
    public void addTilmelding(Tilmelding t){
        tilmeldinger.add(t);
    }
}
