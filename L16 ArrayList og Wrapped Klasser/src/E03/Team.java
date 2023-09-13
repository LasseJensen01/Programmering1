package E03;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name, ArrayList<Player> players){
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player p){
        this.players.add(p);
    }

    public void printPlayers(){
        for (Player player : this.players){
            System.out.println(player.toString());
        }
    }

    public double calcAverageAge(){
        double sum = 0;
        for (Player player : this.players){
            sum += player.getAge();
        }
        return sum / this.players.size();
    }

    public int calcTotalScore(){
        int total = 0;
        for (Player player : this.players){
            total += player.getScore();
        }
        return total;
    }

    public int calcOldPlayerScore(int age){
        int total = 0;
        for (Player player : this.players){
            if (player.getAge() > age){
                total += player.getScore();
            }
        }
        return total;
    }

    public int maxScore(){
        int max = 0;
        for(Player player : this.players){
            if (max < player.getScore()){
                max = player.getScore();
            }
        }
        return max;
    }

    

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
