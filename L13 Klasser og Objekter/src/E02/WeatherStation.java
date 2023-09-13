package E02;

import java.nio.file.Watchable;

public class WeatherStation {
    private double temperatur;
    private double pressure;
    public WeatherStation(){
        this.temperatur = 0;
        this.pressure = 1;
    }
    public WeatherStation(double temperatur, double pressure){
        this.temperatur = temperatur;
        this.pressure = pressure;

    }
    public static WeatherStation fromImperial(double tempInFahrenheit, double pressureInPSI){
        double temp = tempInFahrenheit/1.8-32;
        double press = pressureInPSI/14.503773773;
        WeatherStation WSFIS = new WeatherStation(temp, press);
        return WSFIS;
    }
    public double getTemperatur(){
        return this.temperatur;
    }
    public double getPressure(){
        return this.temperatur;
    }
    public void setTemperatur(double newTemp){
        this.temperatur = newTemp;
        return;
    }
    public void setPressure(double newPress){
        this.pressure = newPress;
        return;
    }
    public void setTemperatureFahrenheit(double newTempInFahren){
        double newTemp = newTempInFahren/1.8-32;
        this.temperatur = newTemp;
    }
    public void setPressurePSI(double newPressInPSI){
        double newPress = newPressInPSI/14.503773773;
        this.pressure = newPress;
    }
    public void printWeatherstation(){
        System.out.println("************");
        System.out.println();
    }

    @Override
    public String toString() {
        return "WeatherStation{" +
                "temperatur=" + temperatur +
                ", pressure=" + pressure +
                '}';
    }
}
