package Ex01;

import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        Customer hans = new Customer("Hans", "Andersen");
        Customer astrid = new Customer("Astrid", "Lindgren");
        Customer ole = new Customer("Ole", "Kirkegaard");
        Customer tove = new Customer("Tove", "Ditlevsen");
        Customer klaus = new Customer("Klaus", "Riftbjerg");
        Customer herman = new Customer("Herman", "Bang");
        Customer henrik = new Customer("Henrik", "Pontoppidan");
        ArrayList<Customer> male = new ArrayList<>();
        ArrayList<Customer> female = new ArrayList<>();
        male.add(hans);
        male.add(ole);
        male.add(klaus);
        male.add(herman);
        male.add(henrik);
        female.add(astrid);
        female.add(tove);
        Collections.shuffle(male);
        Collections.shuffle(female);
        System.out.println(mergeAllCustomers(male,female));
    }

    public static ArrayList customerSort(ArrayList<Customer> s){
        for (int i = 0; i < s.size() - 1; i++){
            int idx = 0;
            Customer min = null;
            for (int j = i; j < s.size(); j++){
                if (min == null || min.getLname().compareTo(s.get(j).getLname()) > 0){
                    min = s.get(j);
                    idx = j;
                }
            }
            s.remove(idx);
            s.add(i, min);
        }
        return s;
    }

    public static ArrayList mergeAllCustomers(ArrayList<Customer> l1, ArrayList<Customer> l2){
        l1 = customerSort(l1);
        l2 = customerSort(l2);
        ArrayList<Customer> s = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < l1.size() && i2 < l2.size()){
            int compared = l1.get(i1).compareTo(l2.get(i2));
            if (compared < 0){
                s.add(l1.get(i1));
                i1++;
            } else if (compared > 0) {
                s.add(l2.get(i2));
                i2++;
            } else if (compared == 0){
                s.add(l1.get(i1));
                i1++;
                s.add(l2.get(i2));
                i2++;
            }
        }
        while (i1 < l1.size()){
            s.add(l1.get(i1));
            i1++;
        }
        while (i2 < l2.size()){
            s.add(l2.get(i2));
            i2++;
        }
        return s;
    }
}
