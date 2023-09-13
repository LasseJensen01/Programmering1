package botlte;

import java.util.Scanner;

public class botle {
    private String name;
    private String content;
    private int amount; // in milliliters
    private String material; // botles materiale

    public botle(String name, String content, int amount, String material){
        this.name = name;
        this.content = content;
        this.amount = amount;
        this.material = material;
    }

    public int getAmount() {
        return amount;
    }

    public void takeDrink(){
        Scanner scanner = new Scanner(System.in);
        boolean hasDrunken = false;
        while (!hasDrunken){
            System.out.println("How much would you like to drink? current content is " + this.amount + "ml");
            System.out.println("pls type in ml");
            int drinkAmount = scanner.nextInt();
            if (drinkAmount > this.amount){
                System.out.println("There is not that much innit pls");
            } else if (drinkAmount < 0){
                System.out.println("funni gtfo");
            } else {
                this.amount -= drinkAmount;
                System.out.println("gluck gluck. new amount is " + this.amount);
                hasDrunken = true;
            }
        }
    }
}
