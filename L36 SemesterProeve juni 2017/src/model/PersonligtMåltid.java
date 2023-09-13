package model;


import java.util.ArrayList;

public class PersonligtMåltid implements Comparable<PersonligtMåltid> {
    private String navn;
    private String anretterNavn;
    private Patient patient;
    private ArrayList<Indtag> indtagelser = new ArrayList<>();

    public PersonligtMåltid(String navn, String anretterNavn, Patient patient){
        this.navn = navn;
        this.anretterNavn = anretterNavn;
        this.patient = patient;
    }

    public Indtag createIndtag(int vejetFørIndtagelse, int vejetEfterIndtagelse, String beskrivelse, int anslåetAntalkalorier){
        Indtag indtag = new Indtag(vejetFørIndtagelse, vejetEfterIndtagelse, beskrivelse, anslåetAntalkalorier);
        this.indtagelser.add(indtag);
        return indtag;
    }

    public int beregnAntalKalorier(){
        ArrayList<Indtag> indtags = new ArrayList<>(this.indtagelser);
        int sum = 0;
        for (Indtag i : indtags){
            double procentDelSpist = i.getVejetEfterIndtagelse()/i.getVejetFørIndtagelse();
            sum += i.getAnslåetAntalKalorier() * procentDelSpist;
        }
        return sum;
    }

    public String getNavn() {
        return navn;
    }

    public String getAnretterNavn() {
        return anretterNavn;
    }

    @Override
    public int compareTo(PersonligtMåltid p){
        int compared = this.getAnretterNavn().compareTo(p.getAnretterNavn());
        if (compared == 0) compared = this.getNavn().compareTo(p.getNavn());
        return compared;
    }
}
