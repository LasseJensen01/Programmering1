package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    public Plads addPlads(int række, int nr, int pris, PladsType pladsType){
        Plads p = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(p);
        return p;
    }
    public Kunde addKunde(String navn, String mobil){
        Kunde k = new Kunde(navn, mobil);
        Storage.addKunde(k);
        return k;
    }
    public Forestilling addForestilling(String navn, LocalDate startDato, LocalDate slutDato){
        Forestilling f = new Forestilling(navn, startDato, slutDato);
        Storage.addForestilling(f);
        return f;
    }
    public ArrayList<Forestilling> getForestillinger(){
        return Storage.getForestillings();
    }
    public ArrayList<Kunde> getkunder(){
        return Storage.getKundes();
    }
    public ArrayList<Plads> getPladser(){
        return Storage.getPlads();
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser){
        Bestilling b = null;
        boolean pladsLedig = false;
        if (dato.isAfter(forestilling.getStartDato().minusDays(1)) && dato.isBefore(forestilling.getSlutDato().plusDays(1))) {
            pladsLedig = true;
            for (Plads p : pladser){
                if (!forestilling.erPladsLedig(p.getRække(), p.getNr(), dato)){
                    pladsLedig = false;
                }
            }
        }
        if (pladsLedig){
            b = new Bestilling(dato,forestilling,pladser,kunde);
            kunde.addBestilling(b);
            forestilling.addBestilling(b);
        }
        return b;
        }
    }
