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
    public void addTilmelding(Tilmelding t){
        tilmeldinger.add(t);
    }
}
