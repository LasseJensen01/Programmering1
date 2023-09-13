package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Patient;
import model.PersonligtMåltid;

import java.util.List;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        initContent(pane);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("FuckShit");
    }

    TextField txtNavn = new TextField();
    TextField txtAnbefaletDaglig = new TextField();
    TextField txtDagligIndtaget = new TextField();
    TextField txtProcentAnbefalet = new TextField();
    ListView<Patient> lwPatienter = new ListView<>();
    Button btnMåltider = new Button("Vis Måldtider");
    ListView<PersonligtMåltid> lwPersonligtMåltid = new ListView<>();


    public void initContent(GridPane pane){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        HBox hBox1 = new HBox();
        hBox1.setSpacing(20);
        hBox1.getChildren().addAll(new Label("Navn:"), txtNavn);
        pane.add(hBox1,0,0);

        HBox hBox2 = new HBox();
        hBox2.setSpacing(20);
        hBox2.getChildren().addAll(new Label("Anbefalet daglig:"), txtAnbefaletDaglig, btnMåltider);
        pane.add(hBox2,0,1);

        HBox hBox3 = new HBox();
        hBox3.setSpacing(20);
    }
}
