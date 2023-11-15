package Ex1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiDemo1 extends Application {
    private TextField txfName = new TextField();
    private TextField txfName2 = new TextField();
    private final TextField fullName = new TextField();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gui Demo 1");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("First Name");
        pane.add(lblName, 0, 0);

        Label lblLastName = new Label("Last Name");
        pane.add(lblLastName, 1, 0);

        Label lblFullName = new Label("Full Name");
        pane.add(lblFullName, 0, 2);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)

        pane.add(txfName, 0, 1);

        pane.add(txfName2, 1, 1);

        pane.add(fullName,0,3, 2, 1);
        fullName.setEditable(false);
        //fullName.setPrefHeight(25);

        Button combineButton = new Button("Combine");
        pane.add(combineButton, 0, 4);
        combineButton.setOnAction(event -> this.fillAction());


        // add a button to the pane (at col=1, row=1)
       /*  Button btnUpperCase = new Button("Upper Case");
        pane.add(btnUpperCase, 1, 1);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // add a button to the pane (at col=2, row=1)
        Button btnLowerCase = new Button("Lower Case");
        pane.add(btnLowerCase, 2, 1);
        GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));*/
    }
    public void fillAction(){
        fullName.setText(combine());
    }
    public String combine(){
        String fn = txfName.getText().trim() + " " + txfName2.getText().trim();
        return fn;
    }
}
