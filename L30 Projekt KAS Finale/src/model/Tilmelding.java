package model;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {

    public enum Type{
        DELTAGER,
        FOREDRAGSHOLDER
    }
    private String ledsager;
    private Type type;
    private LocalDate førsteDag;
    private LocalDate sidsteDag;
    private final Deltager deltager;
    private Aftale aftale = null;
    private Konference konference;
    private final ArrayList<Udflugt> udflugter = new ArrayList<>();
    private final ArrayList<HotelExtra> extras = new ArrayList<>();

    public Tilmelding(String ledsager, Type type, LocalDate førsteDag, LocalDate sidsteDag, Deltager deltager, Konference k){
        this.ledsager = ledsager;
        this.type = type;
        this.førsteDag = førsteDag;
        this.sidsteDag = sidsteDag;
        this.deltager = deltager;
        this.konference = k;
    }
    public void setAftale(Aftale aftale) {
        this.aftale = aftale;
    }
    public String getLedsager() {
        return ledsager;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getFørsteDag() {
        return førsteDag;
    }

    public LocalDate getSidsteDag() {
        return sidsteDag;
    }

    public Deltager getDeltager() {
        return deltager;
    }
    public void addExtra(HotelExtra HE){
        extras.add(HE);
    }
    public void addUdflugt(Udflugt u){
        udflugter.add(u);
    }

    public double getTotalPris(){
        double sum = 0;
        int days = (int) førsteDag.until(sidsteDag, ChronoUnit.DAYS);
        if (type != Type.FOREDRAGSHOLDER){
            sum += konference.getPris() * (days + 1);
        }
        if (aftale != null){
            if (ledsager != null && ledsager.length() > 0){
                sum += aftale.getPrisForDobbel() * days;
            } else{
                sum += aftale.getPris() * days;
            }
            for (int i = 0; i < extras.size(); i++){
                    sum += extras.get(i).getPris() * days;
            }

        }
        if (ledsager != null && ledsager.length() > 0){
            for (int i = 0; i < udflugter.size(); i++){
                sum += udflugter.get(i).getPris();
            }
        }
        return sum;
    }
    public Konference getKonference() {
        return konference;
    }
    @Override
    public String toString() {
        String string = deltager.getNavn();
        if (ledsager != null && ledsager.length() > 0) {
            string += " (" + ledsager + ")";
        }
        string += ", tlf: " + deltager.getTlf() + " type: " + type;
        return string;
    }
}
