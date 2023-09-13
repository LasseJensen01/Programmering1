package E01;

public class Fan {
    public final int SLOW = 1;
    public static int MEDIUM = 2;
    public static int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;


    public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }
    public Fan(String SpeedStr, Boolean on, double radius, String color){
        if (SpeedStr == "FAST"){
            this.speed = FAST;
        } else if (SpeedStr == "MEDIUM"){
            this.speed = MEDIUM;
        } else this.speed = SLOW;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Fan: Speed " + this.speed + ". On is " + this.on + ". Radius is " + this.radius + ". Color is " + this.color);
    }
}
