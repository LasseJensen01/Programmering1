package Ex03;

public class test {
    public static void main(String[] args) {
        Person lasse = new Person("Lasse", 21);
        Person person = new Person("Person", 22);
        lasse.giveGift(new Gift("Smoll PP", 69, person));
        lasse.giveGift(new Gift("Big booba", 420, person));
        lasse.printPerson();
        person.printPerson();

    }
}
