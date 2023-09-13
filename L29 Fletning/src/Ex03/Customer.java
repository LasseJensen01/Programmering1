package Ex03;

public class Customer implements Comparable<Customer> {
    private String name;
    private String lname;
    public Customer(String name, String lname){
        this.name = name;
        this.lname = lname;
    }

    public String getName() {
        return name;
    }

    public String getLname() {
        return lname;
    }

    @Override
    public String toString() {
        return name + " " + lname;
    }

    @Override
    public int compareTo(Customer c) {
        int compared = this.getLname().compareTo(c.getLname());
        if (compared == 0) compared = this.getName().compareTo(c.getName());
        return compared;
    }
}
