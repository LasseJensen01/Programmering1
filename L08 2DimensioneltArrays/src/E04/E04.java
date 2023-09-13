package E04;

public class E04 {
    public static void main(String[] args) {
        double[][] a = {
                {23.5, 35, 2, 10},
                {4.5, 3, 45, 3.5},
                {35, 44, 5.5, 9.6},
        };
        locateSmallest(a);
    }

    public static int[] locateSmallest(double[][] numbers) {
        double lowestNumber = 99;
        int refRow = 0;
        int refCol = 0;
        for (int row = 0; row < numbers.length; row++) {
            for (int col = 0; col < numbers[row].length; col++) {
                if (numbers[row][col] < lowestNumber){
                    lowestNumber = numbers[row][col];
                    refRow = row;
                    refCol = col;
                }
            }
        }
        System.out.println("Smallest number is located in " + refRow + "." + refCol);
        return null;
    }
}
