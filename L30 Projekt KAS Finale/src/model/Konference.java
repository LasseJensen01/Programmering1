package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private double pris;
    private LocalDate startDato;
    private LocalDate slutDato;
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private final ArrayList<Aftale> aftaler = new ArrayList<>();
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Konference(String navn, double pris, LocalDate startDato, LocalDate slutDato){
        this.navn = navn;
        this.pris = pris;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }
    public void addUdflugt(Udflugt u){
        udflugter.add(u);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }
    public void addAftale(Aftale a){
        aftaler.add(a);
    }
    public void addTilmelding(Tilmelding t){
        tilmeldinger.add(t);
    }
    public ArrayList getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }

    public ArrayList<Aftale> getAftaler() {
        return new ArrayList<>(aftaler);
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return navn + ", " + startDato + " til " + slutDato;
    }
}
