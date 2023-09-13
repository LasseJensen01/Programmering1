package model;

import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studieKortNr;
    private String mobil;
    private final ArrayList<Salgsannonce> salgsAnnoncer = new ArrayList();
    public Sælger(String navn, int studieKortNr, String mobil){
        this.navn = navn;
        this.studieKortNr = studieKortNr;
        this.mobil = mobil;
    }
    public ArrayList alleIkkesolgteVarerIKategori(Vare.Varekategori kategori){
        ArrayList<Vare> ikkeSolgteVare = new ArrayList<>();
        for (Salgsannonce s : salgsAnnoncer){
            if (s.isAktiv()){
                for (Vare v : s.getVarer()){
                    if (v.getKategori().equals(kategori) && !v.isSolgt()){
                        ikkeSolgteVare.add(v);
                    }
                }
            }

        }
        return ikkeSolgteVare;
    }

    public ArrayList<Salgsannonce> getSalgsAnnoncer() {
        return new ArrayList<>(salgsAnnoncer);
    }

    public String getNavn() {
        return navn;
    }

    public void addSalgsAnnonce(Salgsannonce s){
        salgsAnnoncer.add(s);
    }

    @Override
    public String toString() {
        return "" + navn;
    }
}
