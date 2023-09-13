package model;

import java.util.Arrays;

public class Team {
    private String name;
    private String room;
    private int studentCounter = 0;
    private Student[] student = new Student[32];
    private static char[] testAnswers = new char[]{'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D', 'A', 'B'};
    public Team(){
    }

    public Team(String name, String room){
        this.name = name;
        this.room = room;
    }
    public void addStudent(Student student){
        this.student[studentCounter] = student;
        studentCounter++;
    }
    public Student[] getStudents(){
        if (this.student.length < 1 ){
            this.student[0] = new Student();
        }
        return this.student;
    }
    public void removeStudent(String name){
        int counter = 0;
        for (int i = 0; i < this.student.length; i++){
            if (student[i] != null && name.equals(student[i].getName())){
                counter = i;
            }
        }
        for (int i = counter; i < this.student.length; i++){
            if (i == student.length - 1){
                student[i] = null;
            } else student[i] = student[i+1];
        }
        studentCounter--;
    }
    public void printStudentsName(){
        int count = 1;
        System.out.println("Names of students in class");
        for (int i = 0; i < this.student.length; i++){
            if (student[i] != null){
            System.out.println(count + ": " + student[i].getName());
            count++;
            }
        }
    }
    public Student[] getStudentArray(){
        Student[] studentsArray = new Student[studentCounter];
        for (int i = 0; i < studentsArray.length; i++){
            studentsArray[i] = student[i];
        }
        return studentsArray;
    }
    public double averageGradeForTeam(){
        double averageGrade = 0;
        int counter = 0;
        for (int i = 0; i < this.studentCounter; i++){
            int[] temp = student[i].getGrade();
            for (int j = 0; j < temp.length; j++){
                averageGrade += temp[j];
                counter++;
            }
        }
        return averageGrade / counter;
    }
    public void highScoreStudents(double minAverage){
        int counter = 0;
        for (int i = 0; i < student.length; i++){
            if (student[i].getActive() == true && student[i].getAverageGrade() >= minAverage){
                counter++;
            }
        }
        Student[] activeStudentMinAverage = new Student[counter];
        int counter2 = 0;
        for (int i = 0; i < student.length; i++){
            if (student[i].getActive() == true && student[i].getAverageGrade() >= minAverage){
                activeStudentMinAverage[counter2] = student[i];
                counter2++;
            }
        }
    }
    public int[] correctAnswersCount(){
        int[] numberOfCorrect = new int[studentCounter];
        for (int i = 0; i < studentCounter; i++){
            char[] temp = student[i].getMultipleChoiceAnswers();
            for (int j = 0; j < temp.length; j++ ){
                if (temp[j] == testAnswers[j]){
                    numberOfCorrect[i]++;
                }
            }
        }
        return numberOfCorrect;
    }
    public static void printTestAnswers() {
        System.out.print("Test Answers:");
        for (char testAnswer : testAnswers) {
            System.out.print(" " + testAnswer);
        }
        System.out.println();
    }
    public String[] studentsOfTeamToString(){
        String[] studentArray = new String[studentCounter];
        for (int i = 0; i < studentArray.length; i++){
            studentArray[i] = String.format("Navn: %-6s %4s %.1f %-5s %d", student[i].getName(), "  Gennemsnit: ", student[i].getAverageGrade(), "  Antal rigtige: ", this.correctAnswersCount()[i]);
        }
        return studentArray;
    }
    public int[] teamAnswerStatistics(){
        int[] correctAnswers = new int[testAnswers.length];
        for (int i = 0; i < studentCounter; i++){
            char[] temp = student[i].getMultipleChoiceAnswers();
            for (int j = 0; j < temp.length; j++ ){
                if (temp[j] == testAnswers[j]){
                    correctAnswers[j]++;
                }
            }
        }
        return correctAnswers;
    }
    public String getTeamName(){
        return this.name;
    }
    public int getStudentCounter(){
        return studentCounter;
    }
}
