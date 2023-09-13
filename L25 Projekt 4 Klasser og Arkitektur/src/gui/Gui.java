package gui;
import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        stage.setScene(scene);
        stage.show();
    }
    Controller controller = new Controller();
    private ListView<Kunde> lwKunder = new ListView<>();
    private ListView<Forestilling> lwForestillinger = new ListView<>();
    private ListView<Plads> lwPladser = new ListView();
    private TextField txtNavn = new TextField();
    private TextField txtStartDato = new TextField();
    private TextField txtSlutDato = new TextField();
    private TextField txtKundeNavn = new TextField();
    private TextField txtKundeMobil = new TextField();
    private TextField txtBestillingsDato = new TextField();


    private void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(new Label("Forestillinger"),0,0);
        pane.add(lwForestillinger,0,1,2,1);
        lwForestillinger.setMaxHeight(200);
        lwForestillinger.getItems().setAll(controller.getForestillinger());

        pane.add(new Label("Kunder"),2,0);
        pane.add(lwKunder,2,1,2,1);
        lwKunder.setMaxHeight(200);
        lwKunder.getItems().setAll(controller.getkunder());

        pane.add(new Label("Pladser"), 4,0);
        pane.add(lwPladser,4,1,2,1);
        lwPladser.setMaxHeight(200);
        lwPladser.getItems().setAll(controller.getPladser());
        lwPladser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        pane.add(new Label("Navn:"),0,2);
        pane.add(txtNavn,1,2);

        pane.add(new Label("Kunde navn:"),2,2);
        pane.add(txtKundeNavn,3,2);

        pane.add(new Label("Start Dato:"), 0, 3);
        pane.add(txtStartDato,1,3);
        txtStartDato.setPromptText("YYYY-MM-DD");

        pane.add(new Label("Slut Dato:"), 0, 4);
        pane.add(txtSlutDato,1,4);
        txtSlutDato.setPromptText("YYYY-MM-DD");

        pane.add(new Label("Kunde mobil"),2,3);
        pane.add(txtKundeMobil,3,3);

        Button btnOpretForstilling = new Button("Opret forestilling");
        btnOpretForstilling.setOnAction(event -> opretForestilling());
        pane.add(btnOpretForstilling,1,5);

        Button btnOpretKunde = new Button("Opret Kunde");
        pane.add(btnOpretKunde,3,4);
        btnOpretKunde.setOnAction(event -> opretKunde());

        Button btnOpretBesttiling = new Button("Opret bestilling");
        // btnOpretBesttiling.setOnAction(event -> ());
        pane.add(btnOpretBesttiling,5,3);
        pane.add(new Label("Dato:"),4,2);
        btnOpretBesttiling.setOnAction(event -> opretBestilling());

        pane.add(txtBestillingsDato,5,2);
        txtBestillingsDato.setPromptText("YYYY-MM-DD");
    }

    private void opretForestilling(){
        if (txtNavn != null && txtStartDato != null & txtSlutDato != null && isValid(txtStartDato.getText()) && isValid(txtSlutDato.getText())){
                LocalDate STdato = LocalDate.parse(txtStartDato.getText());
                LocalDate SLdato = LocalDate.parse(txtSlutDato.getText());
                var f = controller.addForestilling(txtNavn.getText(),STdato,SLdato);
                lwForestillinger.getItems().add(f);
        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("Please check information");
            alert.setContentText("Date is typed as \n yyyy-mm-dd");
            alert.show();
        }
    }
    private void opretKunde(){
        if (txtKundeNavn != null && txtKundeMobil.getCharacters().length() == 8){
            var k = controller.addKunde(txtKundeNavn.getText(), txtKundeMobil.getText());
                lwKunder.getItems().add(k);

        } else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("Please check information");
            alert.setContentText("Mobile number has to be 8 characters");
            alert.show();
        }
    }

    private boolean isValid(String dateStr) {
        boolean duck = true;
        try {
            LocalDate.parse(dateStr);
        } catch (Exception e) {
            duck = false;
        }
        return duck;
    }

    public void opretBestilling(){
        Forestilling f = lwForestillinger.getSelectionModel().getSelectedItem();
        Kunde k = lwKunder.getSelectionModel().getSelectedItem();
        ArrayList<Plads> p = new ArrayList<>(lwPladser.getSelectionModel().getSelectedItems());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setResizable(true);
        if (f != null && k != null && p != null && isValid(txtBestillingsDato.getText())){
            Bestilling b = Controller.opretBestillingMedPladser(f,k,LocalDate.parse(txtBestillingsDato.getText()),p);
            if (b != null){
                alert.setHeaderText("Bestilling oprettet");
                alert.setContentText("" + b.toString());
                alert.show();
            } else {
                alert.setHeaderText("Please check information");
                alert.setContentText("En plads som er valgt er optaget. Vælg venligst nogen andre.");
                alert.show();
            }
        } else {
            alert.setHeaderText("Please check information");
            alert.setContentText("Vælg en forestilling og en kunde og så det antal pladser som du ønsker. \n" +
                    "Sørg også for at din dato er valid");
            alert.show();
        }
    }

}
