package Systemudvikling;

public class Konto {
    private int nr;
    private int saldo;
    private String kontotype;
    private String status;


    public Konto(String kontotype, int nr){
        this.kontotype = kontotype;
        this.nr = nr;
        this.saldo = 0;
        this.status = "Open";
    }
    public void addBalance(int balance) {
        if (this.status == "Open") {
            this.saldo += balance;
        } else System.out.println("Account is closed");
    }
    public void withdrawBalance(int balance) {
        if (this.status == "Open") {
            this.saldo -= balance;
        } else System.out.println("Account is closed");
    }
    public void closeAccount(){
        this.status = "Closed";
    }
    public void openAccount(){
        this.status = "Open";
    }
    public String getStatus(){
        return this.status;
    }
    public int getBalance(){
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Konto{" +
                "nr=" + nr +
                ", saldo=" + saldo +
                ", kontotype='" + kontotype + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
