package gui;

import com.sun.javafx.scene.layout.region.Margins;
import controller.Controller;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class TilmeldingWindow extends Stage {
    public TilmeldingWindow(String title, Stage owner) {
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
    private ListView lwDeltager = new ListView();
    private ComboBox cbType = new ComboBox();
    private TextField txtLedsager = new TextField();
    private TextField txtFørsteDag = new TextField();
    private TextField txtSidsteDag = new TextField();
    private ListView lwAftale = new ListView();
    private ListView lwHotelExtra = new ListView();
    private ListView lwUdflugter = new ListView<>();
    private ComboBox cbFirma = new ComboBox();
    private Button btnOpretTilmelding = new Button("Opret Tilmelding");
    private Konference k = null;
    Controller controller = new Controller();

    public void initContent(GridPane pane){
        //TODO
        k = (Konference) Storage.getKonference().get(0);


        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(new Label("Deltager"),0,0);
        pane.add(lwDeltager,0,1);
        lwDeltager.setMinSize(150,200);
        lwDeltager.setMaxSize(150,200);
        lwDeltager.getItems().setAll(Storage.getDeltagere());

        Label lbltype = new Label("Deltager type:");
        pane.add(lbltype,1,1);
        GridPane.setMargin(lbltype,new Insets(200,0,0,0));
        GridPane.setMargin(txtLedsager,new Insets(-175,0,0,0));
        pane.add(cbType,1,2);
        cbType.getItems().setAll(Tilmelding.Type.values());

        pane.add(btnOpretTilmelding,0,2);
        btnOpretTilmelding.setOnAction(event -> opretTilmelding(event));


        pane.add(new Label("Ledsager:"),1,0);
        pane.add(txtLedsager,1,1);
        GridPane.setMargin(txtLedsager,new Insets(-175,0,0,0));

        Label lbl = new Label("Første dag:");
        pane.add(lbl,1,1);
        GridPane.setMargin(lbl,new Insets(-130,0,0,0));
        pane.add(txtFørsteDag,1,1);
        GridPane.setMargin(txtFørsteDag, new Insets(-75,0,0,0));

        Label lbl2 = new Label("Sidste dag:");
        pane.add(lbl2,1,1);
        GridPane.setMargin(lbl2, new Insets(-20,0,0,0));
        pane.add(txtSidsteDag,1,1);
        GridPane.setMargin(txtSidsteDag, new Insets(35,0,0,0));

        Label lbl3 = new Label("Firma:");
        pane.add(lbl3,1,1);
        GridPane.setMargin(lbl3, new Insets(90,0,0,0));
        pane.add(cbFirma,1,1);
        cbFirma.getItems().setAll(Storage.getFirmaer());
        GridPane.setMargin(cbFirma, new Insets(145,0,0,0));

        pane.add(new Label("Aftale:"), 2,0);
        pane.add(lwAftale,2,1);
        lwAftale.setMaxSize(150,200);
        lwAftale.setMinSize(150,200);
        lwAftale.getItems().setAll(k.getAftaler());
        lwAftale.setOnMouseClicked(event -> aftaleClick(event));

        pane.add(new Label("Hotel Extra:"),3,0);
        pane.add(lwHotelExtra,3,1);
        lwHotelExtra.setMaxSize(150,200);
        lwHotelExtra.setMinSize(150,200);
        lwHotelExtra.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        pane.add(new Label("Udflugter:"),4,0);
        pane.add(lwUdflugter,4,1);
        lwUdflugter.setMaxSize(150,200);
        lwUdflugter.setMinSize(150,200);
        //TODO
        lwUdflugter.getItems().setAll(k.getUdflugter());

    }

    public void aftaleClick(Event event){
        lwHotelExtra.getItems().clear();
        Aftale a = (Aftale) lwAftale.getSelectionModel().getSelectedItem();
        lwHotelExtra.getItems().setAll(a.getHotelExtras());

    }
    public void opretTilmelding(Event event){
        if (lwDeltager.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deltager ikke valgt");
            alert.setHeaderText("Deltager ikke valgt");
            alert.setContentText("Deltager ikke valgt. Vælg en Deltager");
            alert.showAndWait();
            return;
        }
        Deltager d = (Deltager) lwDeltager.getSelectionModel().getSelectedItem();
        if(cbType.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Deltager type ikke valgt");
            alert.setHeaderText("Deltager type ikke valgt");
            alert.setContentText("Deltager type ikke valgt. Vælg en type");
            alert.showAndWait();
            return;
        }
        Tilmelding.Type t = (Tilmelding.Type) cbType.getSelectionModel().getSelectedItem();

        String l = null;
        Firma f = null;
        Aftale a = null;
        LocalDate fDato = null;
        LocalDate sDato = null;
        ArrayList<Udflugt> u = null;
        try{
            fDato = LocalDate.parse(txtFørsteDag.getText());
            sDato = LocalDate.parse(txtSidsteDag.getText());
        } catch (Exception ex){
            System.err.println("Datoer ikke rigtig format");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl i dato");
            alert.setHeaderText("Fejl i datoer");
            alert.setContentText("Fejl i datoer, tjek datoerne igen og se om de er i den rigtige format");
            alert.showAndWait();
            return;
        }

        if (fDato.isBefore(k.getStartDato()) || sDato.isAfter(k.getSlutDato())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fejl i dato");
            alert.setHeaderText("Fejl i datoer");
            alert.setContentText("Indtastede datoer passer ikke ind i konference datoerne.\nIndtast datoer som passer til datoer til konferencen");
            alert.showAndWait();
            return;
        }

        if (txtLedsager.getText().length() > 0){
            l = txtLedsager.getText();
        }

        if (cbFirma.getSelectionModel().getSelectedItem() != null){
            f = (Firma) cbFirma.getSelectionModel().getSelectedItem();
        }

        if (lwAftale.getSelectionModel().getSelectedItem() != null){
            a = (Aftale) lwAftale.getSelectionModel().getSelectedItem();
        }

        if (lwUdflugter.getSelectionModel().getSelectedItems() != null){
            u = (ArrayList<Udflugt>) lwUdflugter.getSelectionModel().getSelectedItems();
        }
        Tilmelding tm = controller.createTilmelding(l,t,fDato,sDato,d,k,a,f);

        if(u != null){
            for (int i = 0; i < u.size(); i++){
                u.get(i).addTilmelding(tm);
            }
        }
        if (a != null){
            a.addTilmelding(tm);
        }
        d.addTilmelding(tm);
    }
}
