package model;

import java.util.ArrayList;

public class Patient {
    private String navn;
    private double vægt;
    private int vægtFaktor;
    private ArrayList<PersonligtMåltid> personligtMåltider = new ArrayList<>();

    public Patient(String navn, double vægt, int vægtFaktor){
        this.navn = navn;
        this.vægt = vægt;
        this.vægtFaktor = vægtFaktor;
    }

    public double beregnAntalAnbefaletkalorier(){
        return this.vægt * this.vægtFaktor;
    }

    public int beregnDagensAntalKalorier(){
        ArrayList<PersonligtMåltid> personligtMåltids = new ArrayList<>(this.personligtMåltider);
        int antalKalorier = 0;
        for (PersonligtMåltid p : personligtMåltids){
            antalKalorier += p.beregnAntalKalorier();
        }
        return antalKalorier;
    }

    public double beregnProcentDagligAnbefalet(){
        double antalAnbefaletKalorier = this.beregnAntalAnbefaletkalorier();
        double dagensAntalKalorier = this.beregnDagensAntalKalorier();
        return (dagensAntalKalorier/antalAnbefaletKalorier)*100;
    }

    public void addMåltid(PersonligtMåltid p){
        personligtMåltider.add(p);
    }
}
