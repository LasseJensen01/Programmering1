package model;

import java.util.ArrayList;

public class Vare {
    public enum Varekategori{
        STUDIEBOG,
        MOBILTELEFON,
        COMPUTER,
        TØJ,
        ANDET
    }
    private Varekategori kategori;
    private String navn;
    private int udbudsPris;
    private boolean solgt;
    private Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudsPris){
        this.kategori = kategori;
        this.navn = navn;
        this.udbudsPris = udbudsPris;
        this.solgt = false;
    }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        this.salgsannonce = salgsannonce;
    }

    public Salgsannonce getSalgsannonce() {
        return salgsannonce;
    }

    public int getUdbudsPris() {
        return udbudsPris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public void setSolgt(boolean solgt) {
        this.solgt = solgt;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        String string = "";
        if (this.isSolgt()){
            string += "Solgt";
        } else string += "Til salg";
        return this.navn + " " + this.udbudsPris + " " + string;
    }
}
