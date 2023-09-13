package Ex01;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GuiListView3 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person Administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox cb = new CheckBox();

    private void initContent(GridPane pane) {
        this.initPersons();

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

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 3);
        Label lblSenior = new Label("Senior:");
        pane.add(lblSenior, 1, 2);
        Label lblTitle = new Label("Title:");
        pane.add(lblTitle,0,1 );

        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitle, 1, 1, 2, 1);

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        pane.add(cb, 1,2);
        GridPane.setMargin(cb, new Insets(0, 0, 0, 40));

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 0);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 6, 3);

        // connect a method to the button
        btnDelete.setOnAction(event -> this.deleteAction());

    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        if (txfName.getText().length() > 0) {
            String name = txfName.getText();
            int idx = name.lastIndexOf(' ');
            String fName = name.substring(0, idx);
            String lName = name.substring(idx +1);
            Person p = new Person(fName, lName, cb.isSelected());
            persons.add(p);
            if (txfTitle.getText().length() > 0){
                p.setTitle(txfTitle.getText());
            }
            lvwPersons.getItems().setAll(persons);
        } else{
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Add Person");
            a.setHeaderText("No name typed");
            a.setContentText("Type the name of the person");
            a.show();
        }
    }

    private void deleteAction() {
        int index = lvwPersons.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            persons.remove(index);
            txfName.clear();
            txfTitle.clear();
            lvwPersons.getItems().setAll(persons);
        }
    }

    private void initPersons() {
        persons.add(new Person("Jan", "Petersen", false));
        persons.add(new Person("Hans", "Hansen", false));
        persons.add(new Person("Pia", "Peters", false));
        persons.add(new Person("Lasse", "Jensen", true));
    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            if (newPerson.getSenior() == false){
                cb.setSelected(false);
            }else cb.setSelected(true);
            txfName.setText(newPerson.getFirstName() + " " + newPerson.getLastName());
            txfTitle.setText(newPerson.getTitle());
        } else {
            txfName.clear();
            txfTitle.clear();
        }
    }
    private void setSenior(){

    }
}
