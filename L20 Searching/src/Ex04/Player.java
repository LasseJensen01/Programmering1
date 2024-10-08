package Ex04;

public class Player {
    private String name;
    private int height;
    private int weight;
    private int scoredGoals;
    public Player(String name, int height, int weight, int scoredGoals){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.scoredGoals = scoredGoals;
    }

    public int getScoredGoals() {
        return scoredGoals;
    }

    @Override
    public String toString() {
        return "Player: " + "Name = " + name +" Height = " + height + " Weight = " + weight + " ScoredGoals = " + scoredGoals;
    }
}
