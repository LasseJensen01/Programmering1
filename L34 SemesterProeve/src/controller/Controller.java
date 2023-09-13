package controller;

import model.Salg;
import model.Salgsannonce;
import model.Sælger;
import model.Vare;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Controller {
    public static Sælger createSælger(String navn, int studieKortNr, String mobil){
        Sælger s = new Sælger(navn, studieKortNr, mobil);
        Storage.addSælger(s);
        return s;
    }
    public static Salgsannonce createSalgsannonce(Sælger sælger){
        Salgsannonce s = new Salgsannonce(sælger);
        sælger.addSalgsAnnonce(s);
        return s;
    }
    public static Vare createVare(Vare.Varekategori kategori, String navn, int udbudsPris){
        Vare v = new Vare(kategori, navn, udbudsPris);
        Storage.addVare(v);
        return v;
    }
    public static Salg createSalg(String navn, int aftaltPris, ArrayList<Vare> vare){
        Salg s = new Salg(navn, aftaltPris, vare);
        Storage.addSalg(s);
        return s;
    }

    public static void salgTilFil(String filNavn){
        String filePath = "L34 SemesterProeve/src/file/";
        filePath += filNavn;
        File file = new File(filePath);
        ArrayList<Salg> salgs = new ArrayList<>(Storage.getSalgs());
        Collections.sort(salgs);
        try (PrintWriter writer = new PrintWriter(filePath)){
            for (Salg s : salgs){
                writer.println(s.getNavn() + ":");
                int samletUdbudsPris = 0;
                for (Vare v : s.getVarer()){
                    writer.println("    " + v.getNavn() + "  " + v.getUdbudsPris());
                    samletUdbudsPris += v.getUdbudsPris();
                }
                int rabat = samletUdbudsPris - s.getAftaltSamletPris();
                writer.println("Aftalt pris: " + s.getAftaltSamletPris() + "  " + "rabat er: " + rabat);
                writer.println();
            }
        }catch (FileNotFoundException ex){
            System.err.println("File not found " + ex.getMessage());
        }
    }

    //TODO
    public static ArrayList sælgerFortagetKøb(){
        ArrayList<Sælger> s = Storage.getSælgere();
        ArrayList<Salg> sa = Storage.getSalgs();
        ArrayList<Sælger> returnSælger = new ArrayList<>();

        return returnSælger;
    }
    public static ArrayList<Salgsannonce> getAktiveAnnoncer(){
        ArrayList<Salgsannonce> returnList = new ArrayList<>();
        ArrayList<Sælger> s = Storage.getSælgere();
        for (Sælger sælger : s){
            for (Salgsannonce sa : sælger.getSalgsAnnoncer()){
                if (sa.isAktiv()){
                    returnList.add(sa);
                }
            }
        }
        return returnList;
    }

    public static void initStorage(){
        Sælger viktor = createSælger("Viktor", 23,"45344247");
        Sælger gustav = createSælger("Gustav", 35,"56124522");

        Vare samMobil = createVare(Vare.Varekategori.MOBILTELEFON, "Samsung mobil", 1200);
        Vare iPhone = createVare(Vare.Varekategori.MOBILTELEFON, "IPhone", 2000);
        Vare bogJava = createVare(Vare.Varekategori.STUDIEBOG, "Java", 400);
        Vare bogAndroid = createVare(Vare.Varekategori.STUDIEBOG, "Android", 300);
        Vare bogPython = createVare(Vare.Varekategori.STUDIEBOG, "Python", 200);
        Vare tøjRegnjakke = createVare(Vare.Varekategori.TØJ, "Regnjakke", 100);
        Vare tøjRegnbukser = createVare(Vare.Varekategori.TØJ, "Regnbukser", 80);

        Salgsannonce sViktor1 = createSalgsannonce(viktor);
        sViktor1.addVare(samMobil);

        Salgsannonce sViktor2 = createSalgsannonce(viktor);
        sViktor2.addVare(bogJava);
        sViktor2.addVare(bogAndroid);
        sViktor2.addVare(bogPython);

        Salgsannonce sGustav1 = createSalgsannonce(gustav);
        sGustav1.addVare(iPhone);

        Salgsannonce sGustav2 = createSalgsannonce(gustav);
        sGustav2.addVare(tøjRegnjakke);
        sGustav2.addVare(tøjRegnbukser);


        ArrayList<Vare> stineKøb = new ArrayList<>();
        stineKøb.add(bogAndroid);
        stineKøb.add(bogPython);

        Salg stine = createSalg("Stine", 450, stineKøb);

        ArrayList<Vare> lauraKøb = new ArrayList<>();
        lauraKøb.add(tøjRegnjakke);
        lauraKøb.add(tøjRegnbukser);

        Salg laura = createSalg("Laura", 120,lauraKøb);
    }
}
