package E02;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
//        ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();

        // Test of sum1() method: correct sum is 61.
        int total1 = sum1(ints);
        System.out.println("Sum: " + total1);

        // Test of sum() method: correct sum is 61.
        int total = sum(ints);
        System.out.println(("Sum: " + total));
        // Test of minimum() method: correct minimum is -16.
        int min = minimum(ints);
        System.out.println("Minimum: " + min);
        // Test of maximum() method: correct maximum is 45.
        int max = maximum(ints);
        System.out.println("Maximum: " + max);
        // Test of average() method: correct average is 7.625.
        double average = average(ints);
        System.out.println("Average: " + average);
        // Test of zeroes() method: correct number of zeroes is 2.
        int zeroes = zeroes(ints);
        System.out.println("Zeroes: " + zeroes);
        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        System.out.println("Evens: " + evens(ints));
    }


    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
    public static int minimum(ArrayList<Integer> list){
        int min = 99;
        for (int i : list){
            if (i < min){
                min = i;
            }
        }
        return min;
    }
    public static int maximum(ArrayList<Integer> list){
        int max = -99;
        for (int i : list){
            if (i > max){
                max = i;
            }
        }
        return max;
    }
    public static double average(ArrayList<Integer> list){
        double sum = 0;
        double average = 0;
        for (int i : list) {
            sum += i;
        }
        return average = sum/list.size();
    }
    public static int zeroes(ArrayList<Integer> list){
        int count = 0;
        for (int i : list){
            if (i == 0){
                count++;
            }
        }
        return count;
    }
    public static ArrayList<Integer> evens(ArrayList<Integer> list){
        ArrayList evens = new ArrayList();
        for (int i : list){
            if (i%2 == 0){
                evens.add(i);
            }
        }
        return evens;
    }
}
