package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnoncer = 1;
    private int anonnceNr;
    private boolean aktiv;
    private LocalDate udløbsDato;
    private final ArrayList<Vare> varer = new ArrayList();
    private final Sælger sælger;

    public Salgsannonce(Sælger sælger){
        this.aktiv = true;
        this.udløbsDato = LocalDate.now().plusMonths(1);
        this.anonnceNr = antalAnnoncer;
        this.sælger = sælger;
        antalAnnoncer++;
    }
    public int samletAnnonceUdbud(){
        int sum = 0;
        for (int i = 0; i < varer.size(); i++){
            sum += varer.get(i).getUdbudsPris();
        }
        return sum;
    }

    public void addVare(Vare vare){
        varer.add(vare);
        vare.setSalgsannonce(this);
    }
    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public boolean isAktiv() {
        return aktiv;
    }
    public void opdaterSalgsannonce(){
        if (LocalDate.now().isAfter(udløbsDato)){
            this.aktiv = false;
        }
        for (Vare v : varer){
         if (!v.isSolgt()){
             return;
         }
        }
        this.aktiv = false;
    }

    @Override
    public String toString() {
        return this.anonnceNr + " " + this.sælger.getNavn() + " " + this.udløbsDato;
    }
}
