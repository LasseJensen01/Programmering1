package Ex01;

import java.util.PrimitiveIterator;

public class Dog {
    private int number;
    private String name;
    private Person person; // Link --> 0..1 Person

    public Dog(int number, String name){
        this.number = number;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", person=" + person.getName() +
                '}';
    }
}
