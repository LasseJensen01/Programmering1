package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import model.Udflugt;

import java.time.LocalDate;

public class KonferenceWindow extends Stage {
    public KonferenceWindow(String title, Stage owner) {
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
    private final TextField txfPris = new TextField();
    private final TextField txfStartDato = new TextField();
    private final TextField txfSlutDato = new TextField();
    Controller controller = new Controller();
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);
        // add textfields
        pane.add(txfNavn,1,1);
        pane.add(txfPris,1,2);
        pane.add(txfStartDato,1,3);
        txfStartDato.setPromptText("YYYY-MM-DD");
        pane.add(txfSlutDato,1,4);
        txfSlutDato.setPromptText("YYYY-MM-DD");
        // add labels
        Label lblOpretKonf = new Label("Opret Konference:");
        pane.add(lblOpretKonf,0,0);
        Label lblNavn = new Label("Navn: ");
        pane.add(lblNavn,0,1);
        Label lblPris = new Label("Pris: ");
        pane.add(lblPris,0,2);
        Label lblStart = new Label("Startdato: ");
        pane.add(lblStart,0,3);
        Label lblSlut = new Label("Slutdato: ");
        pane.add(lblSlut,0,4);
        // add buttons
        Button btnOpret = new Button("Opret");
        pane.add(btnOpret,0,5);
        btnOpret.setOnAction(event -> this.opretAction());
        Button btnAfbryd = new Button("Afbryd");
        pane.add(btnAfbryd,1,5);
        btnAfbryd.setOnAction(event -> this.afbrydAction());
    }
    // -----------------------------------------------------------------
    // Button actions

    /**
     * Clear felterne og lukker vinduet.
     */
    private void afbrydAction() {
    txfNavn.clear();
    txfPris.clear();
    txfStartDato.clear();
    txfSlutDato.clear();
    KonferenceWindow.this.hide();
    }

    /**
     * Opretter et konference objekt baseret på informationen i tekstfelterne.
     * Pre: Navn skal være længere end 0 karakterer, pris skal være > 0,
     * og datoerne skal være i formatten YYYY-MM-DD.
     */
    private void opretAction() {
        /*String navn = txfNavn.getText();
        Double pris = Double.parseDouble(txfPris.getText());
        LocalDate startDato = LocalDate.parse(txfStartDato.getText());
        LocalDate slutDato = LocalDate.parse(txfSlutDato.getText());*/
        if (txfNavn.getText().length() > 0 && txfPris.getText().length() > 0 && txfStartDato.getText().length() > 0 &&
                isValid(txfStartDato.getText()) && txfSlutDato.getText().length() > 0 && txfStartDato.getText().length() > 0
                && isValid(txfSlutDato.getText()) && isValidDouble(txfPris.getText())) {
            String navn = txfNavn.getText();
            Double pris = Double.parseDouble(txfPris.getText());
            LocalDate startDato = LocalDate.parse(txfStartDato.getText());
            LocalDate slutDato = LocalDate.parse(txfSlutDato.getText());
            Konference k = controller.createKonference(navn,pris,startDato,slutDato);
            txfNavn.clear();
            txfPris.clear();
            txfStartDato.clear();
            txfSlutDato.clear();
            //UdflugtWindow.updateList();
            KonferenceWindow.this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fejl");
            alert.setHeaderText("Information mangler/forkert");
            alert.setContentText("Noget af information skrevet er forkert.\nCheck om der er skrevet et navn, om \n" +
                    "prisen er større end 0 og datoerne er rigtige.");
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
    private boolean isValidDouble(String doubleStr) {
        boolean duck = true;
        try {
            Double.parseDouble(doubleStr);
        } catch (Exception e) {
            duck = false;
        }
        return duck;
    }
}
