package gui;
import controller.Controller;
import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Salgsannonce;
import model.Vare;
import org.w3c.dom.Text;
import storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Handelsplatform");
    }

    ListView lwAktiveAnnoncer = new ListView();
    ListView lwVare = new ListView();
    TextField txtKøber = new TextField();
    TextField txtAftaltPris = new TextField();
    TextField txtNavn = new TextField();
    Button btnOpretSalg = new Button("Opret Salg");
    Button btnSalgsfil = new Button("Salgs Fil");
    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(new Label("Aktive annoncer"),0,0);
        pane.add(lwAktiveAnnoncer,0,1);
        lwAktiveAnnoncer.setMaxHeight(250);
        lwAktiveAnnoncer.setMaxWidth(200);
        ArrayList<Salgsannonce> yeet = Controller.getAktiveAnnoncer();
        lwAktiveAnnoncer.getItems().setAll(yeet);
        lwAktiveAnnoncer.setOnMouseClicked(event -> VareListviewClick(event));
        lwAktiveAnnoncer.setOnKeyPressed(event -> VareListviewClick(event));
        lwAktiveAnnoncer.selectionModelProperty().setValue(yeet.get(0));

        pane.add(new Label("Varer"),1,0);
        pane.add(lwVare,1,1);
        lwVare.setMaxHeight(250);
        lwVare.setMaxWidth(200);
        lwVare.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        Label lbl1 = new Label("Køber");
        pane.add(lbl1,2,1);
        GridPane.setMargin(lbl1,new Insets(-200,0,0,0));
        pane.add(txtKøber,3,1);
        GridPane.setMargin(txtKøber, new Insets(-200,0,0,0));

        Label lbl2 = new Label("Aftalt Pris");
        pane.add(lbl2,2,1);
        GridPane.setMargin(lbl2, new Insets(-125,0,0,0));
        pane.add(txtAftaltPris,3,1);
        GridPane.setMargin(txtAftaltPris, new Insets(-125,0,0,0));

        pane.add(btnOpretSalg,2,1);
        GridPane.setMargin(btnOpretSalg, new Insets(-50,0,0,0));
        btnOpretSalg.setOnMouseClicked(event -> btnOpretSalg(event));

        pane.add(new Label("Fil navn"),2,2);
        pane.add(txtNavn,3,2);

        pane.add(btnSalgsfil,2,3);

        btnSalgsfil.setOnAction(event -> btnSalgTilFil(event));
    }
    private void VareListviewClick(Event event){
        Salgsannonce s = (Salgsannonce) lwAktiveAnnoncer.getSelectionModel().getSelectedItem();
        lwVare.getItems().setAll(s.getVarer());
    }

    private void btnOpretSalg(Event event){
        List e = lwVare.getSelectionModel().getSelectedItems();
        ArrayList<Vare> vare = new ArrayList<>(e);
        try{
            for (int i = 0; i < e.size(); i++){
                Vare v = (Vare) e.get(i);
                if (v.isSolgt()){
                    throw new IllegalArgumentException();
                }
            }
            Controller.createSalg(txtKøber.getText(), Integer.parseInt(txtAftaltPris.getText()), vare);
        } catch(Exception ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error tjek indtastet data");
            alert.setHeaderText("Error tjek indtastet data");
            alert.setContentText("Error tjek indtastet data");
            alert.showAndWait();
        }

        lwAktiveAnnoncer.getItems().setAll(Controller.getAktiveAnnoncer());
        lwVare.getItems().clear();
    }
    public void btnSalgTilFil(Event event){
        Controller.salgTilFil(txtNavn.getText().trim());
    }
}
