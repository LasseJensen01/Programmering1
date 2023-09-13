package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {

    private String navn;
    private String mobil;
    private final ArrayList<Bestilling> bestillings = new ArrayList<>();

    public Kunde(String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;
    }

    public void addBestilling(Bestilling b){
        bestillings.add(b);
    }

    public String getNavn() {
        return navn;
    }
    public ArrayList bestiltePladserTilForestillingPådag(Forestilling f, LocalDate d){
        ArrayList<Plads> pladser = new ArrayList<>();
        for (int i = 0; i < bestillings.size(); i++){
            if (bestillings.get(i).getForestilling().equals(f) && bestillings.get(i).getDato().equals(d)){
                pladser.addAll(bestillings.get(i).getPladser());
            }
        }
        return pladser;
    }

    public ArrayList<Bestilling> getBestillings() {
        return bestillings;
    }

    @Override
    public String toString() {
        return navn + " (" + mobil + ")";
    }
}
