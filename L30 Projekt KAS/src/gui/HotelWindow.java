package gui;
import controller.Controller;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Aftale;
import model.Hotel;
import model.Konference;
import storage.Storage;

import javax.naming.InitialContext;
import java.security.PublicKey;
import java.util.ArrayList;

public class HotelWindow extends Stage {
    public HotelWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    private TextField navn = new TextField();
    private TextField adresse = new TextField();
    private Button btnOpretHotel = new Button("Opret Hotel");
    Controller controller = new Controller();
    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(new Label("Navn:"),0,0);
        pane.add(navn,0,1);

        pane.add(new Label("Adresse:"),0,2);
        pane.add(adresse,0,3);

        pane.add(btnOpretHotel,0,4);
        btnOpretHotel.setOnAction(event -> OpretHotel(event));

    }
    public void OpretHotel(Event event){
        if(navn.getText() != null && adresse.getText() != null){
            controller.createHotel(navn.getText(), adresse.getText());
            navn.clear();
            adresse.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Hotel Oprettet");
            alert.setContentText("Hotellet er blevet oprettet korrekt");
            alert.showAndWait();
            HotelWindow.this.hide();
        }else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tjek indtastet data");
            alert.setHeaderText("Tjek indtastet data");
            alert.setContentText("Tjek indtastet data");
            alert.show();
        }
    }
}
