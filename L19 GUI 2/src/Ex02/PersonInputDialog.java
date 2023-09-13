package Ex02;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.security.PrivilegedExceptionAction;

public class PersonInputDialog extends Stage {
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox cb = new CheckBox();
    private String name;
    private String title;
public PersonInputDialog(String title, Stage owner){
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
    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        pane.add(txfName,1, 0, 2, 1);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle,0,1 );
        pane.add(txfTitle,1, 1, 2, 1);

        Label lblSenior = new Label("Senior:");
        pane.add(lblSenior, 1, 2);
        pane.add(cb,1, 2);
        GridPane.setMargin(cb, new Insets(0, 0, 0, 40));

        HBox buttonBox = new HBox(20);
        pane.add(buttonBox, 0, 3);
        buttonBox.setPadding(new Insets(10, 10, 0, 10));
        buttonBox.setAlignment(Pos.TOP_RIGHT);
        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());
        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }
    private void cancelAction() {
        txfName.clear();
        txfName.requestFocus();
        txfTitle.clear();
        name = null;
        title = null;
        PersonInputDialog.this.hide();
    }
    private void okAction(){
    if (txfName.getText().length() > 0){
        name = txfName.getText();
        title = txfTitle.getText();
        txfName.clear();
        txfTitle.clear();
        txfName.requestFocus();
        PersonInputDialog.this.hide();
    }else {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Add Person");
        a.setHeaderText("No name typed");
        a.setContentText("Type the name of the person");
        a.show();
        }
    }

    public String getWName() {
        return name;
    }

    public String getWTitle() {
        return title;
    }
    public boolean getWSenior(){
    return cb.isSelected();
    }
    public void clearWcontent(){
    name = null;
    title = null;
    }
}
