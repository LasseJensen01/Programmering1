package Ex02;

import java.util.ArrayList;

public class Ex02 {
    public static void main(String[] args) {

    }

    public static ArrayList customerSort(ArrayList<Customer> c){
        for (int i = 0; i < c.size() - 1; i++){
            for (int j = i; j < c.size(); i++){

            }
        }
        return c;
    }

    public static String[] selectionSort(String[] s){
        for (int i = 0; i < s.length - 1;i++ ){
            int min = 99;
            int idx = 0;
            String temp = null;
            String temp2 = null;
            for ( int j = i; j < s.length; j++){
                if (min > s[j].length()){
                    min = s[j].length();
                    idx = j;
                }
            }
            temp = s[idx];
            temp2 = s[i];
            s[idx] = temp2 ;
            s[i] = temp;
        }
        return s;
    }
}
