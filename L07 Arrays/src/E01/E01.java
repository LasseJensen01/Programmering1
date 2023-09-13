package E01;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.Arrays;

public class E01 {
    public static void main(String[] args){
        // Array A
        int[] a = new int[10];
        System.out.println("a: " + Arrays.toString(a));
        // Array B
        int[] b = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30};
        System.out.println("b: " + Arrays.toString(b));
        //Array C
        int[] c = new int[10];
        for(int i = 0; i<10; i++){
            c[i] = i;
        }
        System.out.println("c: " + Arrays.toString(c));
        //Array D
        int[] d = new int[10];
        for(int i = 0; i<10; i++){
            d[i]= 2*(i+1);
        }
        System.out.println("d: " + Arrays.toString(d));
        // Array E
        int[] e = new int[10];
        for(int i = 0; i<10; i++){
            e[i] = (i+1)*(i+1);
        }
        System.out.println("e: " + Arrays.toString(e));
        // Array F
        int[] f = new int[10];
        for(int i = 0; i<10;i++){
            if (i%2==0){
                f[i] = 0;
            }
            else{
                f[i] = 1;
            }
        }
        System.out.println("f: " + Arrays.toString(f));
        //Array G
        int[] g = new int[10];
        for(int i = 0; i < 10; i++){
            if (i <= 4){
                g[i] = i;
            }
            else {
                g[i] = i - 5;
            }
        }
        System.out.println("g: " + Arrays.toString(g));
        //Array H
        int[] h = new int[10];
        int count = -1;
        for(int i = 0; i<10;i++){
           if (i%2==0){
               count++;
               h[i] = count;
            }
           else{
               count += 3;
               h[i] = count;
           }
        }
        System.out.println("h: " + Arrays.toString(h));
    }
}
