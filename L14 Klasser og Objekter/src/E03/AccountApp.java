package E03;

import java.util.Scanner;

public class AccountApp {
    static Account[] arrID = new Account[10];
    public static void main(String[] args) {

        for (int i = 0; i < arrID.length; i++){
            arrID[i] = new Account(i, 100);
        }
        while (true){
            processAccount(selectAccount());
        }
    }
    public static int selectAccount(){
        boolean temp = false;
        int tempid = 0;
        while (!temp){
            System.out.println("Please enter which account to process 0 - 9");
            Scanner scanner1 = new Scanner(System.in);
            tempid = scanner1.nextInt();
            if (tempid > 9 || tempid < 0){
                System.out.println("Invalid ID");
            } else temp = true;
        }
        return tempid;
    }
    public static void processAccount(int accountId){
        boolean continueProcess = true;
        while (continueProcess) {
            printMenu(accountId);
            Scanner scanner1 = new Scanner(System.in);
            int temp = scanner1.nextInt();
            if (temp == 1){
                System.out.println("Balance of account " + accountId + " is " + arrID[accountId].getBalance());
            } else if (temp == 2) {
                System.out.println("How much should be withdrawn?");
                arrID[accountId].withdraw(scanner1.nextDouble());
            } else if (temp == 3) {
                System.out.println("How much would you like to deposit?");
                arrID[accountId].deposit(scanner1.nextDouble());
            } else if (temp == 4) {
                continueProcess = false;
            } else System.out.println("Please enter a valid option!");
        }
    }
    public static void printMenu(int accountid){
        System.out.println("***************");
        System.out.println("You are processing account Nr. " + accountid);
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit processing menu");
        System.out.println("***************");
    }
}
