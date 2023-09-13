package E01;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StopWatchApp {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        Scanner scanner1 = new Scanner(System.in);
        stopWatch.start();
        System.out.println("Press enter to stop timer");
        scanner1.nextLine();
        stopWatch.stop();
        stopWatch.elapsedtime();

    }
}
