package storage;

import model.Salg;
import model.Sælger;
import model.Vare;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Storage {
    private static ArrayList<Sælger> sælgere = new ArrayList<Sælger>();
    private static ArrayList<Vare> varer = new ArrayList<Vare>();
    private static ArrayList<Salg> salgs = new ArrayList<Salg>();

    public static void addSælger(Sælger sælger){
        sælgere.add(sælger);
    }
    public static void addVare(Vare vare){
        varer.add(vare);
    }
    public static void addSalg(Salg salg){
        salgs.add(salg);
    }
    public static ArrayList getSælgere(){
        return new ArrayList(sælgere);
    }
    public static ArrayList getVare(){
        return new ArrayList(varer);
    }
    public static ArrayList getSalgs(){
        return new ArrayList(salgs);
    }
}
