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

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * FIX Opret Aftales Konference da den lige PT ikke fungere og bare er låst til en i Storage
 */
public class AftaleWindow extends Stage {
    public AftaleWindow(String title, Stage owner) {
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
    private TextField txtPrisSingle = new TextField();
    private TextField txtPrisDobbel = new TextField();
    private Button btnOpretAftale = new Button("Opret aftale");
    private TextField txtNavn = new TextField();
    private TextField txtPris = new TextField();
    private Button btnOpretHotelExtra = new Button("Opret Hotel Extra");
    private ListView lwKonferencer = new ListView();
    private ListView lwHoteExtra = new ListView();
    private ComboBox cbHotel = new ComboBox();
    private Button btnAfslut = new Button("Afslut");
    Controller controller = new Controller();
    Aftale a = null;

    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(new Label("Aftale:"),0,0);

        pane.add(new Label("Hoteller:"),0,1);
        cbHotel.getItems().setAll(controller.getAllHoteller());
        pane.add(cbHotel,0,2);

        pane.add(new Label("Pris for enkelt:"),0,3);
        pane.add(txtPrisSingle,0,4);

        pane.add(new Label("Pris for dobbelt:"),0,5);
        pane.add(txtPrisDobbel,0,6);

        pane.add(btnOpretAftale,0,7);
        btnOpretAftale.setOnAction(event -> OpretAftale(event));

        pane.add(new Label("Ekstra:"),1,0);

        pane.add(new Label("Navn:"),1,1);
        txtNavn.setDisable(true);
        pane.add(txtNavn,1,2);

        pane.add(new Label("Pris:"),1,3);
        pane.add(txtPris,1,4);
        txtPris.setDisable(true);

        btnOpretHotelExtra.setDisable(true);
        btnOpretHotelExtra.setOnAction(event -> OpretHotelExtra(event));
        pane.add(btnOpretHotelExtra,1,7);

        pane.add(new Label("Hotel Extras:"),2,0);
        lwHoteExtra.setMaxHeight(200);
        lwHoteExtra.setMaxWidth(150);
        pane.add(lwHoteExtra,2,1,1,7);

        pane.add(btnAfslut,0,8);
        btnAfslut.setBorder(Border.stroke(Paint.valueOf("RED")));
        btnAfslut.setTextFill(Paint.valueOf("RED"));
        btnAfslut.setOnMouseClicked(event -> Afslutbtn(event));
    }

    public void OpretAftale(Event event){
        if (txtPrisSingle.getText() != null && txtPrisDobbel.getText() != null && cbHotel.getItems() != null){
            Hotel h = (Hotel) cbHotel.getSelectionModel().getSelectedItem();
            //TODO
            ArrayList<Konference> fuck = Storage.getKonference();
            Konference k = fuck.get(0);
            Double prisEnkelt = Double.parseDouble(txtPrisSingle.getText());
            Double prisDobbelt = Double.parseDouble(txtPrisDobbel.getText());
            a = controller.createAftale(prisEnkelt,prisDobbelt,h,k);
            txtPrisSingle.setDisable(true);
            txtPrisDobbel.setDisable(true);
            cbHotel.setDisable(true);
            btnOpretAftale.setDisable(true);

            txtPris.setDisable(false);
            txtNavn.setDisable(false);
            btnOpretHotelExtra.setDisable(false);
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tjek indtastet data");
            alert.setHeaderText("Tjek indtastet data");
            alert.setContentText("Tjek indtastet data");
            alert.show();
        }
    }

    public void OpretHotelExtra(Event event){
        if (txtNavn.getText() != null && txtPris.getText() != null){
            double pris = Double.valueOf(txtPris.getText());
            controller.createHotelExtra(txtNavn.getText(), pris, a);
            txtNavn.clear();
            txtPris.clear();
            lwHoteExtra.getItems().clear();
            lwHoteExtra.getItems().setAll(a.getHotelExtras());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tjek indtastet data");
            alert.setHeaderText("Tjek indtastet data");
            alert.setContentText("Tjek indtastet data");
            alert.show();
        }

    }
    public void Afslutbtn(Event event){
        txtPrisSingle.clear();
        txtPrisDobbel.clear();
        txtPris.clear();
        txtNavn.clear();
        a = null;
        lwHoteExtra.getItems().clear();
        AftaleWindow.this.hide();
    }
}
