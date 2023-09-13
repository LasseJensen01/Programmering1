package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {
    private LocalDate dato;
    private LocalTime tid;
    private boolean single;
    private final Spiller spiller;
    private final Bane bane;

    public Booking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.spiller = spiller;
        this.bane = bane;
    }

    public LocalDate getDato() {
        return dato;
    }

    public Bane getBane() {
        return bane;
    }

    public boolean isSingle() {
        return single;
    }

    public LocalTime getTid() {
        return tid;
    }

    @Override
    public String toString() {
        String spil = "";
        if (isSingle()){
            spil = "single";
        } else{
            spil = "double";
        }

        return "Bane nr: " + bane.getNummer() + ", dag: " + dato + " kl. " + tid +
                " spil: " + spil + ", spiller: " + spiller.getNavn();
    }
}
