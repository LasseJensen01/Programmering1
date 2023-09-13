package gui;

import controller.Controller;
import javafx.application.Application;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.PladsType;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initstorage();
        Application.launch(Gui.class);
        tester();
    }

    public static void initstorage(){
        Controller controller = new Controller();

        // Forestillinger
        controller.addForestilling("Evita", LocalDate.of(2023,8,10),LocalDate.of(2023, 8,20));
        controller.addForestilling("Lykke Per", LocalDate.of(2023,9,1),LocalDate.of(2023, 9,10));
        controller.addForestilling("Chess", LocalDate.of(2023,8,21),LocalDate.of(2023, 8,30));

        // Kunder
        controller.addKunde("Anders Hansen", "11223344");
        controller.addKunde("Peter Jensen", "12345678");
        controller.addKunde("Niels Madsen", "12341234");

        int pris = 0;
        PladsType type = PladsType.STANDARD;
        for (int række = 1; række <= 15; række++){
            for (int nr = 1; nr <= 20; nr++){

                // Gule sæder 500kr
                if (række < 6 && nr > 2 && nr < 19){
                    pris = 500;
                }
                // Grønne sæder
                else if (række < 6 && nr < 3 || række < 6 && nr > 18 || række > 5 && række < 11 && nr > 2 && nr < 19) {
                    pris = 450;
                    // Blå sæder
                } else pris = 400;
                // PladsTyper
                if (række == 10 && nr > 7 && nr < 13){
                    type = PladsType.KOERESTOL;
                } else if (række == 11 && nr > 7 && nr < 13) {
                    type = PladsType.EKSTRABEN;
                } else type = PladsType.STANDARD;
                controller.addPlads(række, nr, pris, type);
            }
        }
    }

    public static void testPrint(){
        Controller controller = new Controller();
        var forestillnger = controller.getForestillinger();
        var kunder = controller.getkunder();
        var pladser = controller.getPladser();

        for (int i = 0; i < forestillnger.size(); i++ ){
            System.out.println(forestillnger.get(i));
        }
        for (int i = 0; i < kunder.size(); i++ ){
            System.out.println(kunder.get(i));
        }
        for (int i = 0; i < pladser.size(); i++ ){
            System.out.println(pladser.get(i));
        }

    }

    public static void tester(){
        Controller controller = new Controller();
        Forestilling f = controller.getForestillinger().get(0);
        Kunde k = controller.getkunder().get(0);
        LocalDate d = LocalDate.of(2023,8,10);

        System.out.println("Samlet pris for Anders Hansen: " + k.getBestillings().get(0).samletPris());
        System.out.println("Antal bestilte pladser for Evita d. 2023-08-10: " + f.antalBestiltePladserPåDag(d));
        System.out.println("Bedste dag for forestilling Evita: " + f.succesDato());
        System.out.println("Fyldte pladser til Evita 2023-08-10: " + k.bestiltePladserTilForestillingPådag(f,d));


    }
}
