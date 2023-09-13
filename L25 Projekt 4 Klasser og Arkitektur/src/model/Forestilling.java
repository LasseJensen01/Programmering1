package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private final ArrayList<Bestilling> bestillings = new ArrayList<>();
    public Forestilling(String navn, LocalDate startDato, LocalDate slutDato){
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;
    }

    public boolean erPladsLedig(int række, int nr, LocalDate dato){
        boolean erLedig = true;
        for (int i = 0; i < bestillings.size() && erLedig; i++){
            if (bestillings.get(i).getDato().equals(dato)){
                for (int j = 0; j < bestillings.get(i).getPladser().size(); j++){
                    if (bestillings.get(i).getPladser().get(j).getNr() == nr &&
                            bestillings.get(i).getPladser().get(j).getRække() == række){
                        erLedig = false;
                    }
                }
            }
        }
        return erLedig;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void addBestilling(Bestilling b){
        bestillings.add(b);
    }
    public int antalBestiltePladserPåDag(LocalDate d){
        int sum = 0;
        for (int i = 0; i < bestillings.size(); i++){
            if (bestillings.get(i).getDato().equals(d)){
                sum += bestillings.get(i).getPladser().size();
            }
        }
        return sum;
    }

    public LocalDate succesDato(){
        LocalDate dato = null;
        int max = 0;
        LocalDate d = startDato;
            while (!d.isAfter(slutDato)){
                if (max < antalBestiltePladserPåDag(d)){
                    max = antalBestiltePladserPåDag(d);
                    dato = d;
                }
                d = d.plusDays(1);
            }
        return dato;
    }
    @Override
    public String toString() {
        return "" + navn + " (fra " + startDato + " til " + slutDato + ")";
    }
}
