package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.ArrayList;

public class Gui extends Application {
    private HotelWindow dialog1;
    private AftaleWindow dialog2;
    private DeltagerWindow dialog3;
    private FirmaWindow dialog4;
    private TilmeldingWindow dialog5;

    @Override
    public void start(Stage stage) throws Exception{
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane);
        dialog5 = new TilmeldingWindow("Opret tilmelding", stage);
        dialog5.showAndWait();
        initContent(pane);
        stage.setScene(scene);
        stage.show();
    }
    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

    }
}
