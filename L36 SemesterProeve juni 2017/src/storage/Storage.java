package storage;

import model.Patient;

import java.util.ArrayList;

public abstract class Storage {
    private static ArrayList<Patient> patienter = new ArrayList<>();

    public static void addPatient(Patient p){
        patienter.add(p);
    }
    public static ArrayList<Patient> getPatienter(){
        return new ArrayList<>(patienter);
    }
}
