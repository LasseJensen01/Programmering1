package Ex03;

import java.util.logging.Level;

public class Ex03 {
    private static int[] numbers1 = {7, 9, 13, 7, 9, 13};
    private static int[] numbers2 = {7, 9, 13, 13, 9, 7};
    private static int[] numbers3 = {7, 9, 13, 13, 9, 9, 9, 9, 13, 13, 9, 7};
    public static void main(String[] args) {
        System.out.println(exercise1(numbers1));
        System.out.println(exercise1(numbers2));
        System.out.println(exercise2(numbers3, 4));
    }
    public static boolean exercise1(int[] numbers){
        for (int i = 0; i < numbers.length-1; i++){
            if (numbers[i] == numbers[i+1]){
                return true;
            }
        }
        return false;
    }
    public static boolean exercise2(int[] numbers, int n){
        for (int i = 0; i < numbers.length + 1 - n; i++ ){
            boolean matchfound = exercise2help(numbers, i, n);
            if (matchfound){
                return true;
            }
        }
        return false;
    }
    public static boolean exercise2help(int[] numbers, int i, int n){
        int count = 1;
        for (int j = 1; j < n; j++){
            if (numbers[i] != numbers[i+count]){
                return false;
            }
            count++;
        }
        return true;
    }
}
