package model;

import java.util.Arrays;
import java.util.Scanner;

public class MenuApp {
    private static Team[] teamsArray = new Team[10];
    private static int teamCounter = 0;

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        int menuClick = 0;
        while (menuClick != 6){
        printMenu();
        menuClick = scanner1.nextInt();
        switch (menuClick) {
            case 1 -> {
                createTeam();
            }
            case 2 -> {
                createStudent();
            }
            case 3 -> {
                showOneStudentInfo();
            }
            case 4 -> {
                printTeamInfo();
            }
            case 5 -> {
                printAllTeamInfo();
            }
            default -> System.out.println("Not a valid command");
        }
        }
    }

        public static void printMenu() {
            System.out.println("***************");
            System.out.println("1. Create Team");
            System.out.println("2. Create a student");
            System.out.println("3. Show one student's info and results");
            System.out.println("4. Show one team's info and results");
            System.out.println("5. Show info and results for all teams");
            System.out.println("6. Exit program");
            System.out.println("***************");
        }
        public static void createTeam(){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Please enter team name");
            String teamName = scanner1.nextLine();
            System.out.println("Please enter room name");
            String roomName = scanner1.nextLine();
            teamsArray[teamCounter] = new Team(teamName, roomName);
            teamCounter++;
        }
        public static void createStudent(){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Name of team the student shall be assigned to");
            String teamName = scanner1.nextLine();
            if (getTeamFromString(teamName) != null) {

                System.out.println("Enter the students name");
                String studentName = scanner1.nextLine();

                System.out.println("Enter the students active status (true/false)");
                boolean studentActivity = scanner1.nextBoolean();

                getTeamFromString(teamName).addStudent(new Student(studentName, studentActivity));

                System.out.println("How many grades does the student have?");
                int amountOfGrades = scanner1.nextInt();
                System.out.println("Enter the students " + amountOfGrades + " grades");
                int[] temp = new int[amountOfGrades];
                int position = getTeamFromString(teamName).getStudentCounter() - 1;
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = scanner1.nextInt();
                }
                getTeamFromString(teamName).getStudentArray()[position].setGrade(temp);
                System.out.println("--> Student " + studentName + ": Student is active = " + studentActivity + ": with grades" + Arrays.toString(temp));
            } else System.out.println("Team does not exist");
        }
        public static void showOneStudentInfo(){
        Scanner scanner1 = new Scanner(System.in);
            System.out.println("Which team is the wanted student on");
            String teamName = scanner1.nextLine();
            System.out.println("Which student would you like to see");
            String studentName = scanner1.nextLine();
            boolean keepChecking = true;
            for (int i = 0; keepChecking == true && i < getTeamFromString(teamName).getStudentArray().length; i++){
                if (getTeamFromString(teamName).getStudentArray()[i].getName().equals(studentName)){
                    System.out.println(getTeamFromString(teamName).studentsOfTeamToString()[i]);
                    keepChecking = false;
                }
            }
    }
    public static void printAllTeamInfo(){
        for (int i = 0; i < teamsArray.length; i++){
            for (int j = 0;teamsArray[i] != null && j < teamsArray[i].getStudentArray().length; j++){
                System.out.println(teamsArray[i].studentsOfTeamToString()[j]);
            }
        }
        }
        public static void printTeamInfo(){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Which team is the wanted student on");
            String teamName = scanner1.nextLine();
            for (int i = 0; i < getTeamFromString(teamName).getStudentArray().length; i++){
                System.out.println(getTeamFromString(teamName).studentsOfTeamToString()[i]);
            }
        }
        public static void showOneteamInfo(){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter team name");
            String teamName = scanner1.nextLine();
            for (int i = 0; i < teamsArray.length; i++){
                if (teamName.equals(teamsArray[i].getTeamName())){
                    System.out.println("Statistics for team " + teamName);

                } else System.out.println("Team does not exist");
            }
        }
        public static Team getTeamFromString(String teamName){
        int temp = 0;
        for (int i = 0; i < teamsArray.length; i++){
            if (teamsArray[i] != null && teamName.equals(teamsArray[i].getTeamName())){
                return teamsArray[i];
            }
        }
        return null;
        }
    public static int getTeamNrFromString(String teamName){
        int temp = 0;
        for (int i = 0; i < teamsArray.length; i++){
            if (teamsArray[i] != null && teamName.equals(teamsArray[i].getTeamName())){
                return i;
            }
        }
        return 0;
    }
}
