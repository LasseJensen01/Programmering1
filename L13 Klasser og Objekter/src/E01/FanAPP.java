package E01;

public class FanAPP {
    public static void main(String[] args) {
        Fan fan1 = new Fan("FAST", true, 10, "Yellow");
        Fan fan2 = new Fan ("MEDIUM", false, 5, "Blue");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
