package E02EmployeeApp;

public class Employee {
    // The name of the employee.
    String name;
    // Age of employee
    int age;
    // Whether the employee is a trainee or not.
    boolean trainee;

    /** Create an employee. */
    public Employee(String name, int age, boolean trainee) {
        this.name = name;
        this.age = age;
        this.trainee = true;
    }

    @Override
    public String toString() {
        return String.format("Employee(%s, %d, %s)", name, age, trainee);
    }

    /** Print a description of the employee. */
    public void printEmployee() {
        int idx = name.lastIndexOf(" ");
        String firstname = name.substring(0, idx);
        String lastname = name.substring(idx + 1);
        System.out.println("*******************");
        System.out.println("First name: " + firstname);
        System.out.println("Last name: " + lastname);
        System.out.println("Age: " + age);
        System.out.println("Trainee: " + trainee);
        System.out.println("*******************");
    }
}
