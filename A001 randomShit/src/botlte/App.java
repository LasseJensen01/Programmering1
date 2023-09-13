package botlte;

public class App {
    public static void main(String[] args) {
        botle watah = new botle("watah", "water",500,"plastic");
        while (watah.getAmount() > 0){
            watah.takeDrink();
        }
    }

}
