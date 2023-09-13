package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String navn;
    private String klasse;

    //lektion --> 0..*
    private ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }
    public ArrayList<Studerende> sygPåDato(LocalDate dato){
        ArrayList<Studerende> sygStuderende = new ArrayList<>();
        for (Lektion l : lektioner){
            if (l.getDato().equals(dato)){
                ArrayList<Deltagelse> deltagelser = new ArrayList<>(l.getDeltagelser());
                for (Deltagelse d : deltagelser){
                    if (d.erSyg()){
                        Studerende s = d.getStuderende();
                        if(sygStuderende.isEmpty() || !erTilføjet(sygStuderende,s)){
                            sygStuderende.add(s);
                        }
                    }
                }
            }
        }
        return sygStuderende;
    }
    public boolean erTilføjet(ArrayList<Studerende> s, Studerende st){
        for (Studerende stu : s){
            if (stu.equals(st)){
                return true;
            }
        }
        return false;
    }
}
