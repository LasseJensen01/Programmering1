package E01;

import java.util.ArrayList;

public class E01 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Bente");
        names.add("Bent");
        System.out.println(names.size());
        names.add(2, "Jane");
        System.out.println(names);
        names.remove(1);
        names.add(0, "Pia");
        names.add("Ib");
        System.out.println(names.size());
        names.set(2, "Hansi");
        System.out.println(names.size());
        System.out.println(names);
        for (int i = 0; i < names.size(); i++){
            System.out.print(names.get(i).length() + " ");
        }
        System.out.println();
        for (String i : names){
            System.out.print(i.length() + " ");
        }
    }
}
