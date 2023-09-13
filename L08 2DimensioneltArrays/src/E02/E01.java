package E02;

public class E01 {
    public static void main(String[] args) {
        int[][] numbers = {
                {0, 4, 3, 9, 6},
                {1, 3, 5, 2, 2},
                {3, 3, 1, 0, 1},
                {0, 0, 9, 7, 1},
        };
        // First print
        System.out.println("Initial Array");
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%5d ", numbers[row][col]);
            }
            System.out.println();
        }
        //Assignment 1
        int newValue = 5;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = newValue;
            }
        }
        //Print Assignment 1
        System.out.println("First print");
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%5d ", numbers[row][col]);
            }
            System.out.println();
        }
        // Assignment 2
        newValue = 2;
        int newValue2 = 3;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (row % 2 != 0) {
                    numbers[row][col] = newValue;
                } else numbers[row][col] = newValue2;
            }
        }
        //Print Assignment 2
        System.out.println("Second print");
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%5d ", numbers[row][col]);
            }
            System.out.println();
        }
        //Assignment 3
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (col % 2 != 0) {
                    numbers[row][col] = newValue;
                } else numbers[row][col] = newValue2;
            }
        }
        //Print Assignment 3
        System.out.println("Third print");
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%5d ", numbers[row][col]);
            }
            System.out.println();
        }
        //Assignment 4
        newValue = 0;
        newValue2 = 1;
        boolean pog = true;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (pog) {
                    numbers[row][col] = newValue;
                    pog = false;
                } else {
                    numbers[row][col] = newValue2;
                    pog = true;
                }
            }
        }
        //Print assignment 4
        System.out.println("Fourth print");
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                System.out.printf("%5d ", numbers[row][col]);
            }
            System.out.println();
        }
        //Assignment 5
        newValue = 2;
        newValue2 = 5;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                numbers[row][col] = newValue;
            }
        }
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (row == 0 || row == 3) {
                    numbers[row][col] = newValue2;
                }
                if (col == 0 || col == 4) {
                    numbers[row][col] = newValue2;
                }
            }
        }
        //Print assignment 5
            System.out.println("Fifth print");
            for (int row = 0; row < numbers.length; row++) {
                for (int col = 0; col < numbers[row].length; col++) {
                    System.out.printf("%5d ", numbers[row][col]);
                }
                System.out.println();
            }
        }
    }