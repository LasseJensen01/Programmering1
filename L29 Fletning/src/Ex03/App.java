package Ex03;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Customer> s = new ArrayList<>();
        s.add(new Customer("Lucas", "Oppenheimer"));
        s.add(new Customer("Simon", "Frankenstein"));
        s.add(new Customer("Zimmer", "Einstein"));
        s.add(new Customer("Lasse", "Sanchez"));
        s.add(new Customer("Kasper", "Spørg"));
        s.add(new Customer("Alexander", "Sambuca"));
        s.add(new Customer("Shiba", "Inu"));
        s.add(new Customer("Hotel", "Trivago"));

        Customer[] badCustomers = new Customer[4];
        badCustomers[0] = new Customer("Hotel", "Trivago");
        badCustomers[1] = new Customer("Shiba", "Inu");
        badCustomers[2] = new Customer("Lasse", "Sanchez");
        badCustomers[3] = new Customer("Kasper", "Spørg");

        System.out.println(goodCustomers(s, badCustomers));
    }

    public static ArrayList goodCustomers(ArrayList<Customer> all, Customer[] bad){
        ArrayList<Customer> good = new ArrayList<>();
        all = customerSort(all);
        bad = customerSortArray(bad);
        int i1 = 0;
        int i2 = 0;
        while (i1 < all.size() && i2 < bad.length){
            int compared = all.get(i1).compareTo(bad[i2]);
            if (compared != 0){
                good.add(all.get(i1));
                i1++;
            } else {
                i1++;
                i2++;
            }
        }
        while (i1 < all.size()){
            good.add(all.get(i1));
            i1++;
        }
        return good;
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
    public static Customer[] customerSortArray(Customer[] s){
        for (int i = 0; i < s.length - 1; i++){
            int idx = 0;
            Customer min = null;
            for (int j = i; j < s.length; j++){
                if (min == null || min.getLname().compareTo(s[j].getLname()) > 0){
                    min = s[j];
                    idx = j;
                }
            }
            s[idx] = s[i];
            s[i] = min;
        }
        return s;
    }
}
