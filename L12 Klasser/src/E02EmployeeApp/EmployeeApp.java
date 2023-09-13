package E02EmployeeApp;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans Jensen", 30,true);
        Employee e2 = new Employee("Hanne Sommer", 32, true);
        /*System.out.println("Test: " + e1);
        System.out.println();

        System.out.println("Name: " + e1.name);
        System.out.println("Age: " + e1.age);
        System.out.println("Trainee? " + e1.trainee);
        System.out.println();

        e1.trainee = false;*/
        e1.printEmployee();
        System.out.println();
        e2.printEmployee();
    }
}
