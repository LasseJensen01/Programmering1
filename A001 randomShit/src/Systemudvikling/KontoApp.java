package Systemudvikling;

public class KontoApp {
    public static void main(String[] args) {
        Konto Konto = new Konto("Bruger", 01);
        Konto.addBalance(500);
        System.out.println(Konto.getBalance());
        System.out.println(Konto.getStatus());
        Konto.closeAccount();
        System.out.println(Konto.getStatus());
        System.out.println(Konto.toString());

    }
}
