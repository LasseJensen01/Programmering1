package gui;

import controller.Controller;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.w3c.dom.Text;

public class DeltagerWindow extends Stage {

    public DeltagerWindow(String title, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);
        this.setOnCloseRequest(event -> event.consume());
        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
    private TextField txtNavn = new TextField();
    private TextField txtTlf = new TextField();
    private Button btnOpret = new Button("Opret Deltager");
    Controller controller = new Controller();
    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        pane.add(new Label("Navn:"),0,0);
        pane.add(txtNavn,0,1,2,1);

        pane.add(new Label("Telefon nummer:"),0,2);
        pane.add(txtTlf,0,3,2,1);
        pane.add(btnOpret,0,4);
        btnOpret.setOnAction(event -> opretDeltager(event));
        Button btnAfbryd = new Button("Afbryd");
        pane.add(btnAfbryd,1,4);
        btnAfbryd.setOnAction(event -> afbrydAction());
    }

    public void opretDeltager(Event event){
        if (txtNavn != null && txtTlf != null){
            controller.createDeltager(txtNavn.getText(),txtTlf.getText());
            txtNavn.clear();
            txtTlf.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deltager oprettet");
            alert.setHeaderText("Deltager oprettet");
            alert.setContentText("Deltager oprettet korrekt og sendt til storage");
            alert.showAndWait();
            DeltagerWindow.this.hide();
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Tjek indtastet data");
            alert.setHeaderText("Tjek indtastet data");
            alert.setContentText("Tjek indtastet data");
            alert.show();
        }
    }
    private void afbrydAction() {
        txtNavn.clear();
        txtTlf.clear();
        this.close();
    }
}
