package Swimmer2;

import java.util.ArrayList;
import java.util.List;

import Swimmer2.Swimmer;

public class SwimmerApp {

    public static void main(String[] args) {
        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));

        Swimmer jan = new Swimmer("Jan", lapTimesJan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));

        Swimmer bo = new Swimmer("Bo", lapTimesBo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));

        Swimmer mikkel = new Swimmer("Mikkel", lapTimesMikkel);

        TrainingPlan trainingPlanA = new TrainingPlan('A', 16, 10);
        TrainingPlan trainingPlanB = new TrainingPlan('B', 10, 6);

        trainingPlanA.addSwimmer(jan);
        trainingPlanA.addSwimmer(bo);
        trainingPlanB.addSwimmer(mikkel);
        ArrayList<TrainingPlan> traningsplan = new ArrayList<>();
        traningsplan.add(trainingPlanA);
        traningsplan.add(trainingPlanB);

        for (int i = 0; i < traningsplan.size(); i++ ){
            for (int j = 0; j < traningsplan.get(i).getSwimmers().size(); j++){
                System.out.println(traningsplan.get(i).getSwimmers().get(j).getName() + "'s bedste tid er " + traningsplan.get(i).getSwimmers().get(j).bestLapTime());
                System.out.println();
            }
        }
    }
}
