package E03;

public class E03C {
    public static void main(String[] args){
        int result = printPowersOfTwo();
        System.out.println(result);
    }
    public static int printPowersOfTwo(){
        int sum = 2;
        for (int i = 1; i <= 20; i++){
            sum = sum*2;
            System.out.println(sum);
        }
        return sum;
    }
}
