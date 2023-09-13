package Ex02;

public class Person {
    private String firstName;
    private String lastName;
    private String title;
    private boolean senior;

    public Person(String firstName, String lastName, boolean senior) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = "";
        this.senior = senior;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return this.title;
    }
    public boolean getSenior(){
        return this.senior;
    }
    public void setSenior(boolean senior){
        this.senior = senior;
    }
    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return title + " " + firstName + " " + lastName;
    }
}
