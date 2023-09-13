package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Bane bookings");
    }

    private ListView<Bane> lwBaner = new ListView<>();
    private ListView<Spiller> lwSpiller = new ListView<>();
    private TextArea txtABookings = new TextArea();
    private TextArea txtAAntalBookninger = new TextArea();
    private TextField txtDato = new TextField();
    private Label lblDato = new Label("Dato:");
    private Label lblTid = new Label("Tid:");
    private Label lblSingle = new Label("Single");
    private TextField txtTid = new TextField();
    private CheckBox cbSingle = new CheckBox();
    private Button btnBookbane = new Button("Book bane til spiller");

    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(new Label("Baner"),0,0);
        pane.add(lwBaner,0,1);
        lwBaner.setMaxSize(250,175);
        lwBaner.getItems().setAll(Controller.getBaner());

        pane.add(new Label("Spillere"),1,0);
        pane.add(lwSpiller,1,1);
        lwSpiller.setMaxSize(150,175);
        lwSpiller.getItems().setAll(Controller.getSpillere());
        lwSpiller.setOnKeyPressed(event -> spillerensBookningerAction());
        lwSpiller.setOnMouseClicked(event -> spillerensBookningerAction());

        pane.add(new Label("Spillerens bookinger"),2,0);
        pane.add(txtABookings,2,1);
        txtABookings.setMaxSize(325,175);
        txtABookings.setMinSize(325,175);

        pane.add(new Label("Antal bookinger på banen"),0,2);
        pane.add(txtAAntalBookninger,0,3);
        txtAAntalBookninger.setMaxSize(250, 150);
        txtAAntalBookninger.setEditable(false);

        pane.add(new Label("Opret Booking"),2,2);
        pane.add(lblDato,2,3);
        GridPane.setMargin(lblDato,new Insets(-125,0,0,0));

        pane.add(txtDato,2,3);
        txtDato.setMaxWidth(250);
        GridPane.setMargin(txtDato, new Insets(-125,0,0,100));
        txtDato.setPromptText("YEAR-MONTH-DATE");

        pane.add(lblTid,2,3);
        GridPane.setMargin(lblTid, new Insets(-50,0,0,0));

        pane.add(txtTid,2,3);
        txtTid.setMaxWidth(250);
        GridPane.setMargin(txtTid,new Insets(-50,0,0,100));
        txtTid.setPromptText("HOUR:MINUTES:SECONDS");

        pane.add(lblSingle,2,3);
        GridPane.setMargin(lblSingle,new Insets(10,0,0,125));

        pane.add(cbSingle,2,3);
        GridPane.setMargin(cbSingle,new Insets(10,0,0,100));

        pane.add(btnBookbane,2,3);
        GridPane.setMargin(btnBookbane,new Insets(75,0,0,0));
        btnBookbane.setOnAction(event -> opretBooking());
    }

    public void spillerensBookningerAction(){
        Spiller s = lwSpiller.getSelectionModel().getSelectedItem();
        ArrayList<Booking> bookings = new ArrayList<>(s.getBookinger());
        String textSum = "";
        for (Booking b : bookings){
            textSum += b.toString();
            textSum += "\n";
        }
        txtABookings.setText(textSum);
    }

    public void opretBooking(){
        Bane b = null;
        Spiller s = null;
        LocalDate dato = null;
        LocalTime tid = null;
        try{
            b = lwBaner.getSelectionModel().getSelectedItem();
            s = lwSpiller.getSelectionModel().getSelectedItem();
        } catch (NullPointerException ex){
            System.err.println("Error");
        }
        try{
            dato = LocalDate.parse(txtDato.getText());
            tid = LocalTime.parse(txtTid.getText());
        } catch (DateTimeParseException ex){
            System.err.println("Error");
        }
        boolean isSingle = cbSingle.isSelected();

        Controller.createBooking(dato,tid,isSingle,s,b);
        spillerensBookningerAction();
    }

    /*
    public void antalBookningerPåBanenAction(){
        Bane b = lwBaner.getSelectionModel().getSelectedItem();
        int[] antalBookinPrtime = b.antalBookningerPrTime();
        String textSum = "";
        for (int i = 0; i < antalBookinPrtime.length; i++){
            textSum += "Tid: " + i + 9 + " antal: " + antalBookinPrtime[i];
            textSum += "\n";
        }
        txtAAntalBookninger.setText(textSum);
    }

     */
}
