package Ex2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GuiDemo1 extends Application {
    private final TextField numberField = new TextField();
    private int number = 1;

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


        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)

        Label lbltxt = new Label("Number :");
        pane.add(lbltxt, 0, 1);
        GridPane.setMargin(lbltxt, new Insets(-35,-15,0,10));

        pane.add(numberField,1, 1);
        numberField.setPrefWidth(40);
        GridPane.setMargin(numberField, new Insets(-35,10,0,10));
        numberField.setEditable(false);
        numberField.setText("" + number);

        Button inc = new Button("Inc");
        pane.add(inc, 2, 0);
        inc.setOnAction(event -> inc());
        Button dec = new Button("Dec");
        pane.add(dec, 2, 1);
        dec.setOnAction(event -> dec());


        // add a button to the pane (at col=1, row=1)
       /*  Button btnUpperCase = new Button("Upper Case");
        pane.add(btnUpperCase, 1, 1);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // add a button to the pane (at col=2, row=1)
        Button btnLowerCase = new Button("Lower Case");
        pane.add(btnLowerCase, 2, 1);
        GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));*/
    }
    public void inc(){
        number++;
        numberField.setText(Integer.toString(number));
    }
    public void dec(){
        number--;
        numberField.setText("" + number);
    }
}
