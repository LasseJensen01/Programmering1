package model;

public class Student {
    private String name;
    private boolean active;
    private int[] grades;
    private char[] multipleChoiceAnswers = new char[10];

    public Student(){
    this.name = "N/A";
    this.active = false;
}
    public Student(String name, boolean active){
    this.name = name;
    this.active = active;
    this.grades = new int[]{0};
}
    public String getName(){
    return this.name;
    }
    public int getHighestGrade(){
        int higestGrade = 0;
        for (int i: grades){
            if (grades[i] >= higestGrade){
                higestGrade = grades[i];
            }
        }
        return higestGrade;
    }
    public double getAverageGrade(){
        double averageGrade = 0;
        int count = 0;
        for (int i = 0; i < grades.length; i++){
            averageGrade += grades[i];
            count++;
        }
        averageGrade = averageGrade/count;
        return averageGrade;
    }
    public boolean getActive(){
        return active;
    }
    public void setGrade(int[] grade){
        this.grades = grade;
    }
    public int[] getGrade(){
        return this.grades;
    }
    public void fillMultipleChoiceAnswers(){
        for (int i = 0; i < multipleChoiceAnswers.length; i++){
            int choice = (int)(Math.random()* 4) + 1;
            switch(choice){
                case 1 -> multipleChoiceAnswers[i] = 'A';
                case 2 -> multipleChoiceAnswers[i] = 'B';
                case 3 -> multipleChoiceAnswers[i] = 'C';
                case 4 -> multipleChoiceAnswers[i] = 'D';
                default -> multipleChoiceAnswers[i] = 'X';
            }
        }
    }
    public char[] getMultipleChoiceAnswers(){
        return this.multipleChoiceAnswers;
    }
}
