package ex2;

import java.util.Scanner;

public class E102 {
    public static void main(String[] args) {
        System.out.println("Enter the radius");
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.printf("The circle's area is = %.2f\n" , area);
    }
}
