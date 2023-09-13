package E01;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays;

public class E01 {
    public static void main(String[] args) {
        int[][] numbers = {
                {0, 4, 3, 9, 6},
                {1, 3, 5, 2, 2},
                {3, 3, 1, 0, 1},
                {0, 0, 9, 7, 1},
        };
        int row = 0;
        int col = 0;
        int value = 0;
        print(numbers);
        System.out.println("Sum of row " + row + " = " + sumRow(numbers, row));
        System.out.println("Sum of col " + col + " = " + sumColumn(numbers, col));
        System.out.println("Sum = " + sum(numbers));
        System.out.println("Number in Row " + row + " Collum " + col + " = " + getValueAt(numbers,row, col));
        setValueAt(numbers, row, col, value);
        System.out.println("Value for row " + row + " collum " + col + " is now " + value);
    }

    public static void print(int[][] numbers) {
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%5d ", numbers[row][col]);
            }
            System.out.println();
        }
    }

    public static int sumRow(int[][] numbers, int row) {
        int sum = 0;
        for (int i = 0; i < numbers[row].length; i++) {
            sum += numbers[row][i];
        }
        return sum;
    }

    public static int sumColumn(int[][] numbers, int col) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i][col];
        }
        return sum;

    }

    public static int sum(int[][] numbers) {
        int sum = 0;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                sum += numbers[row][col];
            }
        }
        return sum;
    }
    public static int getValueAt(int[][] numbers, int row, int col){
        return numbers[row][col];
    }
    public static void setValueAt(int[][] numbers, int row, int col, int value){
        numbers[row][col] = value;
    }
}
