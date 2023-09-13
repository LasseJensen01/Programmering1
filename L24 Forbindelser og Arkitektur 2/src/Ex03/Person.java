package Ex03;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> giftsGiven = new ArrayList<>();
    private ArrayList<Gift> giftsRecevied = new ArrayList<>();

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void giveGift(Gift gift){
        giftsGiven.add(gift);
        gift.getReceiver().giftsRecevied.add(gift);
    }
    public void receiveGift(Gift gift){
        giftsRecevied.add(gift);
    }

    public String getName() {
        return name;
    }

    public void printPerson(){
        System.out.println("Person: " + name + ". " + age + " years old");
        System.out.println("Gifts given: " + giftsGiven);
        System.out.println("Gifts recevied: " + giftsRecevied);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", giftsGiven=" + giftsGiven +
                ", giftsRecevied=" + giftsRecevied +
                '}';
    }
}
