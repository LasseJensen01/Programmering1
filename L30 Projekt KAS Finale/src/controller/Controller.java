package controller;

import model.*;
import storage.Storage;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    /**
     *Opretter en konference
     * Pre: Slutdato skal være efter Startdato
     */
    public Konference createKonference(String navn, double pris, LocalDate startDato, LocalDate slutDato){
        if(startDato.isAfter(slutDato)){
            throw new IllegalArgumentException("StartDato skal være før slutdato");
        }
        Konference k = new Konference(navn, pris, startDato, slutDato);
        Storage.addKonference(k);
        return k;
    }

    /**
     *Opretter en udflugt til en konference
     * Pre: Dato skal være på eller imellem datoerne for konferencen
     * Note: Skulle konference blive nedlagt, vil alle udflugter knyttet til også blive nedlagt
     */
    public Udflugt createUdflugt(String navn, LocalDate dato, double pris, Konference k){
        if (dato.isBefore(k.getStartDato()) || dato.isAfter(k.getSlutDato())){
            throw new IllegalArgumentException("Dato er ikke imellen konferencens datoer");
        }
        Udflugt u = new Udflugt(navn, dato, pris);
        k.addUdflugt(u);
        return u;
    }

    /**
     *Opretter et Hotel
     */
    public Hotel createHotel(String navn, String Adresse){
        Hotel h = new Hotel(navn, Adresse);
        Storage.addHotel(h);
        return h;
    }

    /**
     *Opretter en aftale for mellem en konference og et hotel
     * Pre: Pris og PrisForDobbel skal være > 0
     */
    public Aftale createAftale(double pris, double prisForDobbel, Hotel h, Konference k){
        if (pris <= 0 && prisForDobbel <= 0){
            throw new IllegalArgumentException("Pris skal være > 0");
        }
        Aftale a = new Aftale(pris, prisForDobbel,h);
        k.addAftale(a);
        return a;
    }

    /**
     *Opretter et HotelExtra til en aftale såsom Morgenmad eller WiFi
     * Pre: Pris skal være > 0
     */
    public HotelExtra createHotelExtra(String navn, double pris, Aftale a){
        if (pris <= 0){
            throw new IllegalArgumentException("Pris skal være > 0");
        }
        HotelExtra he = new HotelExtra(navn, pris);
        a.addHotelExtra(he);
        return he;
    }

    /**
     *Retunere en ArrayList af alle oprettede konferencer
     */
    public ArrayList getAllKonferencer(){
        return Storage.getKonference();
    }

    /**
     *Returnere en ArrayList af alle oprettede hoteller
     */
    public ArrayList getAllHoteller(){
        return Storage.getHoteller();
    }

    /**
     *Opretter en deltager
     */
    public Deltager createDeltager(String navn, String tlf){
        Deltager d = new Deltager(navn, tlf);
        Storage.addDeltager(d);
        return d;
    }

    /**
     *Retunere en liste af deltagere
     */
    public ArrayList getDeltagere(){
        return Storage.getDeltagere();
    }

    /**
     *Opretter en tilmelding
     * Pre: Datoer skal være gyldige for konferencen
     */
    public Tilmelding createTilmelding(String l, Tilmelding.Type type,LocalDate førsteDag, LocalDate sidsteDag, Deltager d, Konference k, Aftale a, Firma f){
        if (k.getStartDato().isAfter(førsteDag) || k.getSlutDato().isBefore(sidsteDag)){
            throw new IllegalArgumentException("Datoer ligger ikke i gyldige datoer for konference");
        }
        Tilmelding t = new Tilmelding(l, type, førsteDag, sidsteDag, d, k);
        if (a != null){
            t.setAftale(a);
            a.addTilmelding(t);
        }
        if (f != null){
            try{
                f.addTilmelding(t);
            }
            catch (Exception ex){
                System.err.println("Error ved adding af tilmelding på firma");
            }

        }
        k.addTilmelding(t);
        return t;
    }

    /**
     *Retunere tilmeldinger for en konference
     */
    public ArrayList getTilmeldinger(Konference k){
        return k.getTilmeldinger();
    }

    /**
     * Opretter et firma
     */
    public Firma createFirma(String navn, String tlf){
        if (navn == null || tlf == null){
            throw new IllegalArgumentException("Error i navn og tlf argument under oprettelse af firma");
        }
        Firma f = new Firma(navn, tlf);
        Storage.addFirma(f);
        return f;
    }

    /**
     * Retunere en ArrayList af firmaer
     * Hvis der ingen firmaer er i Storage, returneres en tom ArrayList
     */
    public ArrayList getFirmaer(){
        return Storage.getFirmaer();
    }
    /**
     * Returnere en ArrayList af String af alle udflugter på en given konference.
     * Hvis der ingen udflugter er på konferencen, returneres en tom ArrayList.
     * Pre: Der skal eksistere en konference.
     */
    public ArrayList<String> getUdflugtListe(Konference k) {
        ArrayList<Udflugt> udflugter = k.getUdflugter();
        ArrayList<String> udflugts = new ArrayList<>();
        for (Udflugt u : udflugter) {
            udflugts.add(u.toString());
        }
        return udflugts;
    }
    /**
     * Returnere en ArrayList af String af alle tilmeldinger på en given konference.
     * Hvis der ingen tilmeldinger er på konferencen, returneres en tom ArrayList.
     * Pre: Der skal eksistere en konference.
     */
    public ArrayList<String> getTilmeldingListe(Konference k) {
        ArrayList<Tilmelding> tilmeldinger = k.getTilmeldinger();
        ArrayList<String> tilmeldings = new ArrayList<>();
        for (Tilmelding t : tilmeldinger) {
            tilmeldings.add(t.toString());
        }
        return tilmeldings;
    }
    /**
     * Returnere en ArrayList af String af alle aftaler på en given konference.
     * Hvis der ingen aftaler er på konferencen, returneres en tom ArrayList.
     * Pre: Der skal eksistere en konference og mindst et hotel, som ikke allerede er knyttet til konferencen.
     */
    public ArrayList<String> getAftaleListe() {
        ArrayList<Aftale> aftaler = new ArrayList<>();
        ArrayList<String> aftales = new ArrayList<>();
        ArrayList<Konference> konferencer = Storage.getKonference();
        for (Konference k : konferencer){
            aftaler.addAll(k.getAftaler());
        }
        for (Aftale a : aftaler) {
            aftales.add(a.aftaleToString());
        }
        return aftales;
    }

    /**
     *Link metode for Udflugt og tilmelding
     */
    public void addUdflugtTilTilmelding(Udflugt u, Tilmelding t) {
        t.addUdflugt(u);
        u.addTilmelding(t);
    }
}
