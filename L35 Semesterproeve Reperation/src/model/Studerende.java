package model;

import controller.Controller;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email){
        this.navn = navn;
        this.email = email;
    }

    //S3 (4 point)
    public int antalFraværsLektioner(){
        int sum = 0;
        for (Deltagelse d : deltagelser){
            if ( d.erRegistreretFraværende()){
                sum++;
            }
        }
        return sum;
    }
    public void addDeltagelse(Deltagelse d){
        deltagelser.add(d);
    }
}
