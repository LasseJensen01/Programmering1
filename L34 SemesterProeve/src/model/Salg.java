package model;

import java.security.PublicKey;
import java.util.ArrayList;

public class Salg implements Comparable<Salg> {
    private String navn;
    private int aftaltSamletPris;
    private ArrayList<Vare> varer = new ArrayList<>();

    public Salg(String navn, int aftaltSamletPris, ArrayList<Vare> varer){
        this.navn = navn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.varer = varer;
        for (Vare v : this.varer){
            v.setSolgt(true);
            v.getSalgsannonce().opdaterSalgsannonce();
        }
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Vare> getVarer() {
        return varer;
    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    @Override
    public int compareTo(Salg s) {
        int compared = this.getNavn().compareTo(s.getNavn());
        if (compared == 0) compared = this.getNavn().compareTo(s.getNavn());
        return compared;
    }
}
