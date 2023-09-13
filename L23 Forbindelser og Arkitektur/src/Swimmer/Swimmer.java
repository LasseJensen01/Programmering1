package Swimmer;

import java.util.ArrayList;

public class Swimmer {
    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
        this.trainingPlan = null;
    }
    public void setTrainingPlan(TrainingPlan trainingPlan){
        this.trainingPlan = trainingPlan;
    }
    public TrainingPlan getTrainingPlan(){
        return this.trainingPlan;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        ArrayList<Double> laptimes = getLapTimes();
        double fastestTime = 99;
        for (int i = 0; i < laptimes.size(); i++){
            if (fastestTime > laptimes.get(i)){
                fastestTime = laptimes.get(i);
            }
        }
        return fastestTime;
    }
    public int allTrainingHours(){
       return getTrainingPlan().getWeeklyStrengthHours() + getTrainingPlan().getWeeklyWaterHours();
    }
}
