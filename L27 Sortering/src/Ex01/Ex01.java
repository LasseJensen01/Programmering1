package Ex01;

import java.util.ArrayList;
import java.util.Collections;

public class Ex01 {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("e");
        s.add("to");
        s.add("tre");
        s.add("fire");
        s.add("feeem");
        s.add("seeeks");
        s.add("syyyyyv");
        s.add("otttttte");
        s.add("niiiiiiii");
        s.add("tiiiiiiiii");
        Collections.shuffle(s);
        System.out.println(s);
        System.out.println(bubbleSort(s));



    }

    public static ArrayList bubbleSort(ArrayList<String> s){
        for (int i = 1; i < s.size(); i++){
            String temp = null;
            for (int j = 0; j < s.size() - i;j++){
                if (s.get(j).length() > s.get(j + 1).length()){
                    temp = s.get(j);
                    s.remove(j);
                    s.add(j+1,temp);
                }
            }
        }
        return s;
    }
    public static ArrayList selectionSort(ArrayList<String> s){
        for (int i = 0; i < s.size() - 1;i++ ){
            int min = 99;
            int idx = 0;
            String temp = null;
            for ( int j = i; j < s.size(); j++){
                if (min > s.get(j).length()){
                    min = s.get(j).length();
                    idx = j;
                }
            }
            //System.out.println(s.get(idx));
            temp = s.get(idx);
            s.remove(idx);
            s.add(i, temp);
        }
        return s;
    }
}
