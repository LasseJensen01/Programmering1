package E02;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private LocalDateTime dateCreated;

    public Account(){
        this.id = (int)Math.random() * (9999 - 1) + 1;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = LocalDateTime.now();
    }
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = LocalDateTime.now();
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
    public double getMonthlyInterestRate(){
        return this.annualInterestRate / 12;
    }
    public double getMonthlyInterest(){
        return this.balance * (this.annualInterestRate / 100);
    }
    public void withdraw(double withdrawAmount){
        this.balance -= withdrawAmount;
    }
    public void deposit(double depositAmount){
        this.balance += depositAmount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annualInterestRate=" + annualInterestRate +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
