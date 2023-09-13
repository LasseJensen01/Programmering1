package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    // Deltagelser --> 0..*
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale){
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }
    public void addDeltagelse(Deltagelse d){
        deltagelser.add(d);
    }

    public LocalDate getDato() {
        return dato;
    }
}
