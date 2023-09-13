package E03;

public class E03B {
    public static void main(String[] args){
        int sum = 0;
        for (int i=1; i <= 100; i++){
            if (i*i <= 100){
                sum += i*i;
            }
        }
        System.out.println(sum);
    }
}
