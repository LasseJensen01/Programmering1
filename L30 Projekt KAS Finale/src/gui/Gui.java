package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.*;
import storage.Storage;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.EventListener;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("KAS - Konference Administrations Systemet");

        konferenceWindow = new KonferenceWindow("Opret Konference", stage);
        udflugtWindow = new UdflugtWindow("Opret Udflugt",stage);
        hotelWindow = new HotelWindow("Opret Hotel",stage);
        aftaleWindow = new AftaleWindow("Opret Aftale",stage);
        deltagerWindow = new DeltagerWindow("Opret Deltager",stage);
        firmaWindow = new FirmaWindow("Opret Firma",stage);
        tilmeldingWindow = new TilmeldingWindow("Opret Tilmelding", stage);
    }
    private final ListView<Konference> listKonferencer = new ListView<>();
    private final TextArea txaTilmeldinger = new TextArea();
    private final TextArea txaUdflugter = new TextArea();
    private final TextArea txaHoteller = new TextArea();
    private KonferenceWindow konferenceWindow;
    private UdflugtWindow udflugtWindow;
    private HotelWindow hotelWindow;
    private AftaleWindow aftaleWindow;
    private DeltagerWindow deltagerWindow;
    private FirmaWindow firmaWindow;
    private TilmeldingWindow tilmeldingWindow;
    Controller controller = new Controller();
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);
        // add listviews
        pane.add(listKonferencer,0,1);
        listKonferencer.setMaxHeight(160);
        listKonferencer.setMaxWidth(250);
        listKonferencer.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listKonferencer.getSelectionModel().selectedItemProperty().addListener(event ->
                this.printOverview(listKonferencer.getSelectionModel().getSelectedItem()));
        //printOverview((Konference) Storage.getKonference().get(0));
        //listKonferencer.requestFocus();
        pane.requestFocus();
        updateKonferencer();
        pane.add(txaTilmeldinger,1,1);
        txaTilmeldinger.setMaxWidth(250);
        txaTilmeldinger.setMaxHeight(160);
        txaTilmeldinger.setEditable(false);
        txaUdflugter.setMaxWidth(250);
        txaUdflugter.setMaxHeight(160);
        txaUdflugter.setEditable(false);
        pane.add(txaUdflugter,2,1);
        txaHoteller.setMaxWidth(250);
        txaHoteller.setMaxHeight(160);
        txaHoteller.setEditable(false);
        pane.add(txaHoteller,3,1);
        // add labels
        Label lblKonferencer = new Label("Konferencer:");
        pane.add(lblKonferencer,0,0);
        Label lblTilmelding = new Label("Tilmeldinger:");
        pane.add(lblTilmelding,1,0);
        Label lblUdflugter = new Label("Udflugter:");
        pane.add(lblUdflugter,2,0);
        Label lblHoteller = new Label("Hoteller:");
        pane.add(lblHoteller,3,0);
        // add buttons
        Button btnKonference = new Button("Opret Konference");
        pane.add(btnKonference,0,2);
        btnKonference.setOnAction(event -> this.opretKonferenceAction());
        Button btnUdflugt = new Button("Opret Udflugt");
        pane.add(btnUdflugt,2,2);
        btnUdflugt.setOnAction(event -> this.opretUdflugtAction());
        Button btnOpretHotel = new Button("Opret Hotel");
        pane.add(btnOpretHotel,3,2);
        btnOpretHotel.setOnAction(event -> this.opretHotelAction());
        Button btnOpretAftale = new Button("Opret Aftale");
        pane.add(btnOpretAftale,3,3);
        btnOpretAftale.setOnAction(event -> this.opretAftaleAction());
        Button btnOpretTilmelding = new Button("Opret Tilmelding");
        pane.add(btnOpretTilmelding,1,3);
        btnOpretTilmelding.setOnAction(event -> this.opretTilmelding());
        Button btnOpretDeltager = new Button("Opret Deltager");
        pane.add(btnOpretDeltager,1,2);
        btnOpretDeltager.setOnAction(event -> this.opretDeltager());
        Button btnOpretFirma = new Button("Opret Firma");
        pane.add(btnOpretFirma,0,2);
        GridPane.setMargin(btnOpretFirma,new Insets(0,0,0,130));
        btnOpretFirma.setOnAction(event -> this.opretFirma());
        ArrayList<String> aftaler = controller.getAftaleListe();
        for (String a : aftaler) {
            txaHoteller.appendText(a.toString());
            txaHoteller.appendText("\n");
        }
    }
    //-------------------------------------------------------------------------
    // Button actions
    private void opretKonferenceAction() {
        konferenceWindow.showAndWait();
        // wait for dialog window to close....
        updateKonferencer();
    }
    private void opretUdflugtAction() {
        if (listKonferencer.getSelectionModel().getSelectedItem() != null){
            udflugtWindow.setKonference(listKonferencer.getSelectionModel().getSelectedItem());
            udflugtWindow.showAndWait();
            // wait for dialog window to close....
            printOverview(listKonferencer.getSelectionModel().getSelectedItem());
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error, vælg en konference");
            alert.setContentText("Please vælg en konference at oprette en udflugt for");
            alert.showAndWait();
        }

    }
    private void opretHotelAction() {
        hotelWindow.showAndWait();
        // wait for dialog window to close....
    }
    private void opretAftaleAction() {
        if (listKonferencer.getSelectionModel().getSelectedItem() != null){
            aftaleWindow.updateComboBox();
            aftaleWindow.setKonference(listKonferencer.getSelectionModel().getSelectedItem());
            aftaleWindow.showAndWait();
            // wait for dialog window to close....
            printOverview(listKonferencer.getSelectionModel().getSelectedItem());
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error, vælg en konference");
            alert.setContentText("Please vælg en konference at oprette en aftale for");
            alert.showAndWait();
        }

    }
    private void opretDeltager() {
        deltagerWindow.showAndWait();
    }
    private void opretFirma() {
        firmaWindow.showAndWait();
    }
    private void opretTilmelding(){
        if (listKonferencer.getSelectionModel().getSelectedItem() != null){
            Konference k = listKonferencer.getSelectionModel().getSelectedItem();
            tilmeldingWindow.setKonference(k);
            tilmeldingWindow.updateWindow(k);
            tilmeldingWindow.showAndWait();
            // wait for dialog window to close....
            printOverview(listKonferencer.getSelectionModel().getSelectedItem());
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error, vælg en konference");
            alert.setContentText("Please vælg en konference at oprette en tilmelding for");
            alert.showAndWait();
        }


    }
    //----------------------------------------------------------------------------
    // Helper methods
    public void updateKonferencer() {
        listKonferencer.getItems().setAll(controller.getAllKonferencer());
    }
    public void printOverview(Konference k) {
        txaTilmeldinger.clear();
        txaUdflugter.clear();
        txaHoteller.clear();
        ArrayList<String> tilmeldinger = controller.getTilmeldingListe(listKonferencer.getSelectionModel().getSelectedItem());
        for (String t : tilmeldinger) {
            txaTilmeldinger.appendText(t.toString());
            txaTilmeldinger.appendText("\n");
        }
        ArrayList<String> udflugter = controller.getUdflugtListe(listKonferencer.getSelectionModel().getSelectedItem());
        for (String u : udflugter) {
            txaUdflugter.appendText(u.toString());
            txaUdflugter.appendText("\n");
        }
        ArrayList<String> aftaler = controller.getAftaleListe();
        for (String a : aftaler) {
            txaHoteller.appendText(a.toString());
            txaHoteller.appendText("\n");
        }
    }
}
