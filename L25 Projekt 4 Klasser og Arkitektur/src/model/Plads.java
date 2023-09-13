package model;

public class Plads {

    private int række;
    private int nr;
    private int pris;
    private PladsType pladsType;

    public Plads(int række, int nr, int pris, PladsType pladsType){
        this.række = række;
        this.nr = nr;
        this.pris = pris;
        this.pladsType = pladsType;
    }

    public int getNr() {
        return nr;
    }

    public int getRække() {
        return række;
    }

    public int getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Rk " + række + ". nr " + nr + ". (" + pris + "kr, Type = " + pladsType + ")\n";
    }
}
