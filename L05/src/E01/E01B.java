package E01;

public class E01B {
    public static void main (String[] args){
        int counter = 1;
        int o = 0;
        while (counter <= 100){
            if(Math.pow(counter, 2)<=100){
                o += Math.pow(counter,2);
            }
            counter++;
        }
        System.out.println(o);
    }
}
