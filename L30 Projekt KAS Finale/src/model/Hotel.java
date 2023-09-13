package model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private String adresse;

    public Hotel(String navn, String adresse){
        this.navn = navn;
        this.adresse = adresse;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return navn + ", " + adresse;
    }
}
