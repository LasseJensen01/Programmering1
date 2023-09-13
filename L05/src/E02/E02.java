package E02;

public class E02 {
    public static void main(String[] args) {
        printPowersOfTwo();
    }
    public static void printPowersOfTwo(){
        int count = 1;
        int prev = 1;
        int print = 0;
        while(count <= 20){
            print = 2 * prev;
            prev = print;
            count++;
        }
        System.out.println(print);
    }
}
