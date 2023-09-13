package gui;

import controller.Controller;
import model.Bane;
import model.Kategori;
import model.Spiller;
import javafx.application.Application;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        initContent();
        Application.launch(Gui.class);
    }

    public static void initContent(){
        // Kategoriere
        Kategori luksus = Controller.createKategori("Luksus",100,200);
        Kategori mellem = Controller.createKategori("Mellem",50,100);
        Kategori begynder = Controller.createKategori("Begynder",25,50);

        //Baner
        LocalTime førsteTid = LocalTime.of(9,0,0);
        LocalTime sidsteTid = LocalTime.of(17,0,0);

        Bane bane1 = Controller.createBane(1,true,førsteTid,sidsteTid,luksus);
        Bane bane2 = Controller.createBane(2,true,førsteTid,sidsteTid,luksus);
        Bane bane3 = Controller.createBane(3,true,førsteTid,sidsteTid,mellem);
        Bane bane4 = Controller.createBane(4,false,førsteTid,sidsteTid,mellem);
        Bane bane5 = Controller.createBane(5,false,førsteTid,sidsteTid,begynder);
        Bane bane6 = Controller.createBane(6,false,førsteTid,sidsteTid,begynder);

        //Spillere
        Spiller andreas = Controller.createSpiller("Andreas","DMU");
        Spiller petra = Controller.createSpiller("Petra","DMU");
        Spiller henrik = Controller.createSpiller("Henrik", "ITA");
        Spiller ulla = Controller.createSpiller("Ulla","ITA");

        //Bookinger
        Controller.createBooking(LocalDate.of(2023,6,20),
                LocalTime.of(10,0,0), true, andreas,bane3);
        Controller.createBooking(LocalDate.of(2023,6,22),
                LocalTime.of(10,0,0), false, andreas,bane2);

        Controller.createBooking(LocalDate.of(2023,6,20),
                LocalTime.of(11,0,0), false, henrik,bane3);

        Controller.createBooking(LocalDate.of(2023,6,20),
                LocalTime.of(16,0,0), false, ulla,bane3);
        Controller.createBooking(LocalDate.of(2023,6,23),
                LocalTime.of(17,0,0), true, ulla,bane5);

    }
}
