package controller;

import model.Indtag;
import model.Patient;
import model.PersonligtMåltid;
import storage.Storage;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Service {

    public static Patient createPatient(String navn, double vægt, int vægtFaktor){
        Patient p = new Patient(navn,vægt,vægtFaktor);
        Storage.addPatient(p);
        return p;
    }

    public static PersonligtMåltid createPersonligtMåltid(String navn, String anretternavn,Patient patient){
        PersonligtMåltid p = new PersonligtMåltid(navn, anretternavn,patient);
        patient.addMåltid(p);
        return p;
    }

    public static ArrayList<Indtag> findIndtagMedKalorier(ArrayList<Indtag> indtags, int antalKalorier){
        ArrayList<Indtag> nyIndtags = new ArrayList<>();
        for (Indtag i : indtags){
            if(i.getAnslåetAntalKalorier() >= antalKalorier){
                nyIndtags.add(i);
            }
        }
        return nyIndtags;
    }

    public static ArrayList<PersonligtMåltid> personligtMåltidSort(ArrayList<PersonligtMåltid> p){
        Collections.sort(p);
        return p;
    }

    /**
     * Pre: Tager en ArrayList som er sorteret
     */
    public static void indsætMåltid(ArrayList<PersonligtMåltid> personligtMåltider, PersonligtMåltid pM){
        int compare1 = 0;
        int compare2 = 0;
        boolean notSorted = true;
        int count = 0;
        while (notSorted){
            PersonligtMåltid p = personligtMåltider.get(count);
            compare1 = p.getAnretterNavn().compareTo(pM.getAnretterNavn());
            if (compare1 <= 0){
                compare2 = p.getNavn().compareTo(pM.getNavn());
                if (compare2 <= 0);
            } else{
                personligtMåltider.add(count, pM);
                notSorted = false;
            }
            count++;
            if (count > personligtMåltider.size()){
                notSorted = false;
            }
        }
    }
}
