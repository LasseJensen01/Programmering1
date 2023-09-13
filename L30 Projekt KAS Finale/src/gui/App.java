package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initstorage();
        Application.launch(Gui.class);
    }

    public static void initstorage(){
        Controller controller = new Controller();

        //Konferencer
        Konference h = controller.createKonference("Hav og Himmel", 1500, LocalDate.of(2021,12,18),
                LocalDate.of(2021,12,20));
        // Konference a = controller.createKonference("Anime Fest", 1200, LocalDate.of(2023,05,12), LocalDate.of(2023,05,15));

        //Hoteller
        Hotel p = controller.createHotel("Pension Tusindefryd", "HvorDuIkkeEr vej 69");
        Hotel d = controller.createHotel("Den Hvide Svane", "LigeDer Gade 69");
        Hotel hp = controller.createHotel("Hotel Phønix", "Den Varme Fugl");

        //Deltager
        Deltager fm = controller.createDeltager("Finn Madsen","42416570");
        Deltager np = controller.createDeltager("Niels Petersen","54287560");
        Deltager uh = controller.createDeltager("Ulla Hansen","23942044");
        Deltager ps = controller.createDeltager("Peter Sommer","29384958");
        Deltager lj = controller.createDeltager("Lone Jensen","92384758");
        //Aftaler & HotelExtra
        Aftale tusindefryd = controller.createAftale(500,600,p ,h);
        controller.createHotelExtra("Morgenmad",100,tusindefryd);
        Aftale hvideSvane = controller.createAftale(1050,1250,d,h);
        HotelExtra wifi = controller.createHotelExtra("WIFI",50,hvideSvane);
        Aftale phønix = controller.createAftale(700,800,hp,h);
        controller.createHotelExtra("Bad",200,phønix);
        controller.createHotelExtra("WIFI",75,phønix);

        // Udflugter
        Udflugt ob = controller.createUdflugt("Byrundtur, Odense",LocalDate.of(2021,12,18),125,h);
        Udflugt es = controller.createUdflugt("Egeskov", LocalDate.of(2021,12,19),75,h);
        Udflugt tmk = controller.createUdflugt("Trapholt Museum, Kolding", LocalDate.of(2021,12,20),200,h);
        // Tilmeldinger
        Tilmelding finn = controller.createTilmelding(null, Tilmelding.Type.DELTAGER,LocalDate.of(2021,12,18),
                LocalDate.of(2021,12,20),fm,h,null,null);
        Tilmelding niels = controller.createTilmelding(null, Tilmelding.Type.DELTAGER,LocalDate.of(2021,12,18),
                LocalDate.of(2021,12,20),np,h,hvideSvane,null);
        Tilmelding ulla = controller.createTilmelding("Hans Hansen", Tilmelding.Type.DELTAGER,LocalDate.of(2021,12,18),
                LocalDate.of(2021,12,19),uh,h,null,null);
        controller.addUdflugtTilTilmelding(ob,ulla);
        Tilmelding peter = controller.createTilmelding("Mie Sommer", Tilmelding.Type.DELTAGER,LocalDate.of(2021,12,18),
                LocalDate.of(2021,12,20),ps,h,hvideSvane,null);
        controller.addUdflugtTilTilmelding(es,peter);
        controller.addUdflugtTilTilmelding(tmk,peter);
        peter.addExtra(wifi);
        Tilmelding lone = controller.createTilmelding("Jan Madsen", Tilmelding.Type.FOREDRAGSHOLDER,LocalDate.of(2021,12,18),
                LocalDate.of(2021,12,20),lj,h,hvideSvane,null);
        controller.addUdflugtTilTilmelding(ob, lone);
        controller.addUdflugtTilTilmelding(es,lone);
        lone.addExtra(wifi);
        System.out.println(finn.getTotalPris());
        System.out.println(niels.getTotalPris());
        System.out.println(ulla.getTotalPris());
        System.out.println(peter.getTotalPris());
        System.out.println(lone.getTotalPris());
    }
}
