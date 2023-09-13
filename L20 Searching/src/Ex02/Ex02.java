package Ex02;

public class Ex02 {
    private static int[] numbers = {7, 56,34, 3, 7, 14, 13, 4};
    public static void main(String[] args) {
        System.out.println(exercise2(numbers));
    }
    public static int exercise2(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] >= 10 && numbers[i] <= 15){
                return numbers[i];
            }
        }
        return -1;
    }
}
