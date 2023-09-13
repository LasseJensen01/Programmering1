package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import model.Udflugt;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Queue;

public class UdflugtWindow extends Stage {
    public UdflugtWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);
        this.setOnCloseRequest(event -> event.consume());
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // ------------------------------------------------------------------
    private final TextField txfNavn = new TextField();
    private final TextField txfDato = new TextField();
    private final TextField txfPris = new TextField();
    private Konference konference = null;

    Controller controller = new Controller();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);
        // add textfields
        pane.add(txfNavn, 0, 2, 2, 1);
        //txfNavn.setAlignment(Pos.BASELINE_CENTER);
        pane.add(txfDato, 0, 4, 2, 1);
        txfDato.setPromptText("YYYY-MM-DD");
        //txfDato.setAlignment(Pos.BASELINE_CENTER);
        pane.add(txfPris, 0, 6, 2, 1);
        //txfPris.setAlignment(Pos.BASELINE_LEFT);
        // add labels
        Label lblOpretUdflugt = new Label("Opret Udflugt:");
        pane.add(lblOpretUdflugt, 0, 0);
        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 1);
        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 3);
        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 0, 5);
        // add buttons
        Button btnOpret = new Button("Opret");
        pane.add(btnOpret, 0, 7);
        btnOpret.setOnAction(event -> this.opretAction());
        Button btnAfbryd = new Button("Afbryd");
        pane.add(btnAfbryd, 1, 7);
        btnAfbryd.setOnAction(event -> this.afbrydAction());
    }

    //---------------------------------------------------------------
    // Button actions
    private void opretAction() {
        if (txfNavn.getText().length() > 0 && txfPris.getText().length() > 0 && txfDato.getText().length() > 0 && isValid(txfDato.getText())) {
            Udflugt u = null;
            try {
                String navn = txfNavn.getText();
                Double pris = Double.parseDouble(txfPris.getText());
                LocalDate dato = LocalDate.parse(txfDato.getText());
                u = controller.createUdflugt(navn, dato, pris, konference);
            } catch (IllegalArgumentException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Fejl");
                alert.setHeaderText("Forkert dato");
                alert.setContentText(ex.getMessage());
                alert.show();
            }
            if (u != null) {
                setKonference(null);
                afbrydAction();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fejl");
            alert.setHeaderText("Information mangler/forkert");
            alert.setContentText("Noget af information skrevet er forkert.\nCheck om der er skrevet et navn, om \n" +
                    "prisen er større end 0 og datoerne er rigtige.");
            alert.show();
        }
    }

    private void afbrydAction() {
        txfNavn.clear();
        txfPris.clear();
        txfDato.clear();
        UdflugtWindow.this.hide();
    }

    public void setKonference(Konference k) {
        konference = k;
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
}
