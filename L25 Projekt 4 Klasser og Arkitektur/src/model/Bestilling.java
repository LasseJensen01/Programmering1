package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {
    private LocalDate dato;
    private Forestilling forestilling;
    private final ArrayList<Plads> plads;
    private Kunde kunde;

    public Bestilling(LocalDate dato, Forestilling forestilling, ArrayList<Plads> plads, Kunde kunde){
        this.dato = dato;
        this.forestilling = forestilling;
        this.plads = plads;
        this.kunde = kunde;
    }

    public LocalDate getDato() {
        return dato;
    }

    public ArrayList<Plads> getPladser() {
        return plads;
    }

    public int samletPris(){
        int sum = 0;
        for (Plads p : plads){
            sum += p.getPris();
        }
        return sum;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    @Override
    public String toString() {
        String content = "";
        content += forestilling.getNavn() + "\n";
        for (Plads p : plads){
            content += p.toString();
        }
        content += "\n";
        content += kunde.getNavn();
        return  content;
    }
}