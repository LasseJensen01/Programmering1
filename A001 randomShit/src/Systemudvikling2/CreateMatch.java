package Systemudvikling2;

public class CreateMatch {
    private double time;
    private String location;
    private String ref;
    private CreateRank Rank;
    private CreateTeam team;
    private int regResult;

    public CreateMatch(double time, String location, String ref, CreateRank rank, CreateTeam team){
        this.time = time;
        this.location = location;
        this.ref = ref;
        this.Rank = rank;
        this.team = team;
        this.regResult = 0;
    }
}
