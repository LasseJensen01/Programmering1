package Ex02;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,8,10,12,14};
        int[] arr2 = new int[]{1,2,4,5,6,9,12,17};
        // int[] fuck = mergeTwoIntArrays(arr,arr2);
        int [] fuck = sharedNumbers(arr,arr2);
        for (int i = 0; i < fuck.length; i++){
            System.out.println(fuck[i]);
        }
    }
    public static int[] mergeTwoIntArrays(int[] arr1, int[] arr2){
        int[] s = new int[arr1.length + arr2.length];
        int s1 = 0;
        int i1 = 0;
        int i2 = 0;
        while(i1 < arr1.length && i2 < arr2.length){
            if (arr1[i1] < arr2[i2]){
                s[s1] = (arr1[i1]);
                i1++;
                s1++;
            } else {
                s[s1] = (arr2[i2]);
                i2++;
                s1++;
            }
        }
        while (i1 < arr1.length){
            s[s1] = (arr1[i1]);
            i1++;
            s1++;
        }
        while (i2 < arr2.length){
            s[s1] = (arr2[i2]);
            i2++;
            s1++;
        }
        return s;
    }
    public static int[] sharedNumbers(int[] arr1, int[] arr2){
        int[] s = new int[arr1.length + arr2.length];
        int i1 = 0;
        int i2 = 0;
        int c = 0;
        while (i1 < arr1.length && i2 < arr2.length){
            int compared = Integer.compare(arr1[i1], arr2[i2]);
            if (compared == 0){
                s[c] = arr1[i1];
                i1++;
                i2++;
                c++;
            } else if (compared < 0) {
                i1++;
            } else i2++;
        }
        int[] fuck = new int[c];
        for (int i = 0; i < fuck.length; i++){
            fuck[i] = s[i];
        }
        return fuck;
    }
}
