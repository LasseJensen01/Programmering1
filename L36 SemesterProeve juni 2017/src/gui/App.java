package gui;

import controller.Service;
import javafx.application.Application;
import model.Patient;
import model.PersonligtMåltid;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);

    }

    public static void initStorage(){
        Patient p1 = Service.createPatient("Jens Jensen",98.9,26);
        Patient p2 = Service.createPatient("Jens Hansen", 56.5, 38);

        PersonligtMåltid PM1 = Service.createPersonligtMåltid("Morgenmad", "Katrine",p1);
        PersonligtMåltid PM2 =  Service.createPersonligtMåltid("Middagsmad", "Karen",p2);
        PersonligtMåltid PM3 =  Service.createPersonligtMåltid("Aftensmad", "Simon",p2);

        PM1.createIndtag(290,0,"Cornflakes",850);
        PM1.createIndtag(100,0,"Appelsinjuice",250);

        PM2.createIndtag(350, 100,"Leverpostej",1200);
        PM2.createIndtag(150,0,"Bacon",600);

        PM3.createIndtag(450,150,"Forlorn Hare",1500);
        PM3.createIndtag(100,0,"Flødesovs",300);
    }
}
