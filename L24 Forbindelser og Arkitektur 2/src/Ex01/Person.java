package Ex01;

import java.util.ArrayList;

public class Person {
    private String name;
    private String cpr;
    private String phone;
    private ArrayList<Dog> dogs = new ArrayList<>(); // Link --> 0..* Dog

    public Person(String name, String cpr, String phone){
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public String getCpr() {
        return cpr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
        dog.setPerson(this);
    }

    public ArrayList getDog() {
        return dogs;
    }

    public void printPerson(){
        System.out.println(toString());
        for (int i = 0; i < dogs.size(); i++){
            System.out.println(dogs.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cpr='" + cpr + '\'' +
                ", phone='" + phone + '\'' +
                ", dogs=" + dogs +
                '}';
    }
}
