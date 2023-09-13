package E03PersonApp;

public class Person {
    String name;
    String adress;
    int monthlySalary;

    public Person(String name, String adress){
        this.name = name;
        this.adress = adress;
    }
    public Person(String name) {
        this(name, "N/A");
    }
    public double calculateYearlySalary(){
        double yearlySalary = monthlySalary*12*1.025;
        return yearlySalary;
    }

    public void printPerson(){
        System.out.println("**************");
        System.out.println("Name: " + name);
        System.out.println("Address: " + adress);
        System.out.println("Yearly salary: " + calculateYearlySalary());
        System.out.println("**************");
    }
    @Override
    public String toString() {
        return String.format("Person(%s, %s)", name, adress);
    }
}