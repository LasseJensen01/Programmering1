import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class Gui extends Application{
    private GridPane pane = new GridPane();

    @Override
    public void start(Stage stage) throws Exception{
        Scene scene = new Scene(pane);
        initContent();
        stage.setScene(scene);
        stage.show();
    }
    Button btnExit = new Button("Exit");
    private int count = 0;
    public void initContent(){
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);
        pane.setMinHeight(200);
        pane.setMinWidth(200);
        pane.setGridLinesVisible(true);
        pane.add(btnExit,0,0);
        btnExit.setOnAction(event -> buttonAction());
    }

    public void buttonAction(){

    }
}
