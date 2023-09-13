package E03PersonApp;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person ("Hans Hansen", "VejVejsen 42");
        //System.out.println(p1.toString());
        p1.monthlySalary = 8500;
        p1.printPerson();
        System.out.println();
    }
}
