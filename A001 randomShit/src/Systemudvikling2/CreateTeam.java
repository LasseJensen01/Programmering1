package Systemudvikling2;

public class CreateTeam {
    private String Trainer;
    private CreateRank Rank;
    private int playeramount;
    private String name;
    private int matchesWon;

    public CreateTeam(){
        this.name = "N/A";
        this.Trainer = "N/A";
        CreateRank CreateRank = null;
        this.Rank = CreateRank;
        this.playeramount = 0;
        this.matchesWon = 0;
    }
    public CreateTeam(String name, String Trainer, CreateRank rank, int playeramount){
        this.name = name;
        this.Trainer = Trainer;
        this.Rank = rank;
        this.playeramount = playeramount;
        this.matchesWon = 0;
    }
}
