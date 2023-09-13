package studieStartProve;

import javafx.scene.SnapshotParameters;

import java.util.Scanner;

public class LasseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indtast Navn");
        String name = scanner.nextLine();
        System.out.println("Indtast løn");
        int salary = scanner.nextInt();
        System.out.println("Indtast alder");
        int age = scanner.nextInt();

        double newSalary = 0;
        if (age >= 50){
            newSalary = salary * 1.10;
        } else if (age < 35){
            newSalary = salary * 1.05;
        } else newSalary = salary * 1.08;

        System.out.println(name + "din nye løn er: " + newSalary);
    }
}
