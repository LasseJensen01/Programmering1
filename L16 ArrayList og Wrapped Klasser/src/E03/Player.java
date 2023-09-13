package E03;

public class Player {
    private String name;
    private int age;
    private int score;
    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Player(" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ')';
    }
}
