package model;

public class App {
    public static void main(String[] args) {
        Team team2 = new Team("Team1", "room1");

        Student lasse = new Student("Lasse", true);
        Student daniel = new Student("Daniel", true);
        Student patrick = new Student("Patrick", true);

        team2.addStudent(lasse);
        team2.addStudent(daniel);
        team2.addStudent(patrick);

        lasse.fillMultipleChoiceAnswers();
        daniel.fillMultipleChoiceAnswers();
        patrick.fillMultipleChoiceAnswers();

        Student[] team2Students = team2.getStudentArray();
        team2Students[0].setGrade(new int[]{10, 7, 4});
        team2Students[1].setGrade(new int[]{10, 7, 4});
        team2Students[2].setGrade(new int[]{10, 7, 4, 10, 7, 4});

        System.out.println("Average grade for team 2 is " + team2.averageGradeForTeam());
        for (int i = 0; i < team2.correctAnswersCount().length; i++) {
            System.out.print(team2.correctAnswersCount()[i] + " ");
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < team2.teamAnswerStatistics().length; i++){
            System.out.print(team2.teamAnswerStatistics()[i] + " ");
        }
        System.out.println();
    }
}
