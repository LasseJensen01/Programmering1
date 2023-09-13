package gui;

import controller.Controller;
import javafx.application.Application;
import model.Deltager;
import model.Firma;
import model.Hotel;
import model.Konference;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initstorage();
        Application.launch(Gui.class);
    }

    public static void initstorage(){
        Controller controller = new Controller();

        //Konferencer
        Konference h = controller.createKonference("Hav og Himmel", 1500, LocalDate.of(2021,12,18), LocalDate.of(2021,12,20));
        Konference a = controller.createKonference("Anime Fest", 1200, LocalDate.of(2023,05,12), LocalDate.of(2023,05,15));


        //Hoteller
        Hotel p = controller.createHotel("Pension Tusindefryd", "HvorDuIkkeEr vej 69");
        Hotel d = controller.createHotel("Den Hvide Svane", "LigeDer Gade 69");
        Hotel hp = controller.createHotel("Hotel Phønix", "Den Varme Fugl");

        //Deltager
        Deltager jw = controller.createDeltager("Jakob Wolf", "69696969");
        Deltager lj = controller.createDeltager("Lasse Jensen", "42042042");

        //Aftaler & HotelExtra
        controller.createAftale(500,600,p ,h);
        controller.createAftale(1050,1250,d,h);
        controller.createAftale(700,800,hp,h);


        // Firma
        Firma EAA = controller.createFirma("EAA", "30303030");
    }
}
