package Ex01;

public class Ex01 {
    private static int[] numbers = {10, 7, 40, -14, 8};
    public static void main(String[] args) {
        System.out.println(exercise01(numbers));
    }
    public static boolean exercise01(int[] numbers){
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i]%2 != 0){
                return true;
            }
        }
        return false;
    }
}
