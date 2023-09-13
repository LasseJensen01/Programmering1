package controller;

import model.Deltagelse;
import model.Fag;
import model.Lektion;
import model.Studerende;
import storage.Storage;

import java.util.ArrayList;

public abstract class Controller {
    public static ArrayList<Fag> getFag(){
        return Storage.getFag();
    }
    public static Deltagelse opretDeltagelse(Lektion lektion, Studerende studerende){
        Deltagelse d = new Deltagelse(studerende, lektion);
        lektion.addDeltagelse(d);
        studerende.addDeltagelse(d);
        return d;
    }
}
