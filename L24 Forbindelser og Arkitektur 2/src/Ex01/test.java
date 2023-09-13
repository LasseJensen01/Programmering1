package Ex01;

public class test {
    public static void main(String[] args) {
        Person lasse = new Person("Lasse", "3423659999", "+45 69696969");
        Person lykke = new Person("lykke", "3423658888", "+45 68686868");

        Dog milo = new Dog(1, "Milo");
        Dog balder = new Dog(2, "Balder");
        Dog laban = new Dog(3, "Laban");
        Dog bonnie = new Dog(4, "Bonnie");

        lasse.addDog(milo);
        lasse.addDog(balder);
        lykke.addDog(laban);
        lykke.addDog(bonnie);
        lasse.printPerson();
        lykke.printPerson();
    }
}
