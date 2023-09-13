package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {
    private String navn;
    private LocalDate dato;
    private double pris;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Udflugt(String navn, LocalDate dato, double pris){
        this.navn = navn;
        this.dato = dato;
        this.pris = pris;
    }

    public void addTilmelding(Tilmelding t){
        tilmeldinger.add(t);
    }


}
