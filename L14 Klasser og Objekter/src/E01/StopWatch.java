package E01;

import java.time.Duration;
import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;
    public StopWatch(){
        this.startTime = null;
        this.endTime = null;
    }
    public void start(){
        this.startTime = LocalTime.now();
    }
    public void stop(){
        this.endTime = LocalTime.now();

    }
    public void elapsedtime(){
        System.out.print("Time elapsed is = ");
        System.out.print(this.endTime.toSecondOfDay() - this.startTime.toSecondOfDay());
        System.out.println(" seconds");
    }
}
