package model;

import java.time.LocalDate;
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
    private final Aftale aftale;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Tilmelding(String ledsager, Type type, LocalDate førsteDag, LocalDate sidsteDag, Deltager deltager, Aftale aftale){
        this.ledsager = ledsager;
        this.type = type;
        this.førsteDag = førsteDag;
        this.sidsteDag = sidsteDag;
        this.deltager = deltager;
        this.aftale = aftale;
    }
}
