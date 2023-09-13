package ex2;

import java.util.Scanner;

public class E105 {
    public static void main (String[] args) {
        //Entering of Value a
        System.out.println("Enter the first number");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();

        //Entering of Value b
        System.out.println("Enter the second number");
        Scanner scanner2 = new Scanner(System.in);
        double b = scanner2.nextDouble();

        //Display a & b in order of value
        if (a<=b){
            System.out.println(a + " " + b);}
        else {System.out.println(b + " " + a);}
        }
    }
