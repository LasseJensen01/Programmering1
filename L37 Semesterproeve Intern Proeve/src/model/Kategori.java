package model;

public class Kategori {
    private String navn;
    private int prisKrsingle;
    private int prisKrDouble;

    public Kategori(String navn, int prisKrsingle, int prisKrDouble) {
        this.navn = navn;
        this.prisKrsingle = prisKrsingle;
        this.prisKrDouble = prisKrDouble;
    }

    public int getPrisKrDouble() {
        return prisKrDouble;
    }

    public int getPrisKrsingle() {
        return prisKrsingle;
    }

    public String getNavn() {
        return navn;
    }
}
