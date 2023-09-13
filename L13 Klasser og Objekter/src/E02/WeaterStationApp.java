package E02;

public class WeaterStationApp {
    public static void main(String[] args) {
        WeatherStation WS1 = new WeatherStation();
        WeatherStation WS2 = new WeatherStation(35, 0.5);
        System.out.println(WeatherStation.fromImperial(68, 21));
        System.out.println(WS1.toString());
        System.out.println(WS2.toString());

    }
}
