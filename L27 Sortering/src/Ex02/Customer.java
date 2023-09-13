package Ex02;

public class Customer {
    private String navn;
    private int alder;

    public Customer(String navn, int alder){
        this.navn = navn;
        this.alder = alder;
    }

    public int compareTo(Customer c){
        return this.alder - c.alder;
    }
}
