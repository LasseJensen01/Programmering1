package E03;

import java.util.ArrayList;

public class Ex3 {
    public static void main(String[] args) {
        Player Ib = new Player("Ib", 32);
        Player Johan = new Player("Johan", 29);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(Ib);
        players.add(Johan);
        Team NewTeam = new Team("Oompa Loompas", players);
        NewTeam.printPlayers();
        System.out.println(NewTeam.calcAverageAge());
        System.out.println(NewTeam.calcTotalScore());

    }
}
