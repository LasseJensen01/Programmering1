package model;

import java.util.ArrayList;

public class Aftale {
    private double pris;
    private double prisForDobbel;
    private final Hotel hotel;
    private final ArrayList<HotelExtra> hotelExtras = new ArrayList<>();
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Aftale(double pris, double prisForDobbel, Hotel hotel){
        this.pris = pris;
        this.prisForDobbel = prisForDobbel;
        this.hotel = hotel;
    }

    public void addHotelExtra(HotelExtra he){
        hotelExtras.add(he);
    }

    public ArrayList<HotelExtra> getHotelExtras() {
        return new ArrayList<>(hotelExtras);
    }

    public Hotel getHotel() {
        return hotel;
    }
    public void addTilmelding(Tilmelding t){
        tilmeldinger.add(t);
    }
    private String extrasToString() {
        String extras = "";
        for (HotelExtra he : hotelExtras) {
            extras += he.toString() + "\n";
        }
        return extras;
    }
    private String gæsterToString() {
        String gæster = "";
        for (Tilmelding t : tilmeldinger) {
            if (t.getLedsager() == null){
                gæster += t.getDeltager().getNavn()+ "\nKonference: " + t.getKonference().getNavn() + "\nFra: "
                        + t.getFørsteDag() + " Til: " + t.getSidsteDag() + "\n";
            } else{
                gæster += t.getDeltager().getNavn() + " & " + t.getLedsager()+"\nKonference: " +t.getKonference().getNavn() + "\nFra: " +
                        t.getFørsteDag() + " Til: " + t.getSidsteDag() + "\n";
            }
        }
        return gæster;
    }
    public String aftaleToString(){
        return "Hotel: " + hotel.getNavn() + "\nPris for single: " + pris + "\nPris for dobbel: " + prisForDobbel
                + "\nEkstra tilkøb:\n" + extrasToString() + "\nGæster:\n" + gæsterToString();
    }

    public double getPris() {
        return pris;
    }

    public double getPrisForDobbel() {
        return prisForDobbel;
    }

    @Override
    public String toString() {
        return "Hotel: " + hotel.getNavn() + "\nPris for single: " + pris + "\nPris for dobbel: " + prisForDobbel
                + "\nEkstra tilkøb:\n" + extrasToString();
    }
}
