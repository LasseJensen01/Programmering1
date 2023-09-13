package Ex04;

import java.util.ArrayList;

public class test {
    private static ArrayList<Player> players = new ArrayList<>();
    public static void main(String[] args) {
        players.add(new Player("Geo", 180, 75, 3));
        players.add(new Player("Leo", 180, 75, 2));
        players.add(new Player("Teo", 180, 75, 1));
        players.add(new Player("Keo", 180, 75, 4));
        players.add(new Player("Feo", 180, 75, 0));
        players.add(new Player("Seo", 180, 75, 1));
        players.add(new Player("Peo", 180, 75, 3));
        System.out.println(findPlayerLinear(4));
    }
    public static Player findPlayerLinear(int n){
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getScoredGoals() == n){
                return players.get(i);
            }
        }
        return null;
    }
}
