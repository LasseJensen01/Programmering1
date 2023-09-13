package model;

public class HotelExtra {
    private String navn;
    private double pris;

    public HotelExtra(String navn, double pris){
        this.navn = navn;
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "" + navn + " " + pris + "dkk";
    }
}
