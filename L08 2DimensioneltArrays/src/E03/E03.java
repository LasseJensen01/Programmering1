package E03;

public class E03 {
    public static void main(String[] args){
        double[][] m = {
                {1, 2, 3, 4},
                {5, 6.5, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(averageMajorDiagonal(m));
    }
    public static double averageMajorDiagonal(double[][] m){
        double sum = 0;
        for (int row = 0; row < m.length; row++){
            for (int col = 0; col < m[row].length; col++){
                if(row == col){
                    sum += m[row][col];
                }
            }
        }
        sum = sum/m.length;
        return sum;
    }
}
