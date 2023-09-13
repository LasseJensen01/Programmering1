package Ex03;

import java.security.PrivilegedExceptionAction;

public class Gift {
    private String description;
    private double price;
    private Person receiver;
    public Gift(String description, double price, Person receiver){
        this.description = description;
        this.price = price;
        this.receiver = receiver;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    public Person getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return "Description: " + description + ". Price: " + price + ". Receiver: " + receiver.getName();
    }
}
