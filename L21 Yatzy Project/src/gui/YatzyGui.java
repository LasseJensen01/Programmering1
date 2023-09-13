package gui;

import com.sun.javafx.scene.layout.region.Margins;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.YatzyDice;
import org.w3c.dom.Text;
import javax.swing.Timer;

import java.util.ArrayList;

public class YatzyGui extends Application {
    private YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // txfValues shows the face values of the 5 dice.
    private final TextField[] txfValues = new TextField[5];
    // cbxHolds shows the hold status of the 5 dice.
    private final CheckBox[] cbxHolds = new CheckBox[5];
    // txfResults shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final Label[] lblHold = new Label[5];
    private boolean[] hold = new boolean[5];
    private final ArrayList<TextField> txfResults = new ArrayList<>(15);
    // Shows points in sums, bonus and total.
    private final String[] strings = {"1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One pair", "Two pair", "Three same", "Four same", "Full house", "Small str", "Large str", "Chance", "Yatzy!"};
    private final TextField txfSumSame = new TextField();
    private final TextField txfBonus = new TextField();
    private final TextField txfSumOther = new TextField();
    private final TextField txfTotal = new TextField();

    private final Label lblThrowCount = new Label("Count:");
    private final TextField txfThrowcount = new TextField();
    private final Button btnThrow = new Button(" Throw ");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // add txfValues, chbHolds
        for (int i = 0; i < txfValues.length; i++){
            txfValues[i] = new TextField();
            txfValues[i].setPrefWidth(50);
            txfValues[i].setMaxWidth(50);
            txfValues[i].setPrefHeight(50);
            txfValues[i].setEditable(false);
            cbxHolds[i] = new CheckBox();
            lblHold[i] = new Label("Hold");
        }
        for (int i = 0; i < txfValues.length; i++){
            dicePane.add(txfValues[i], i, 0);
            dicePane.add(cbxHolds[i],i,1);
            int temp = i;
            cbxHolds[i].setOnAction(event -> holdPressAction(temp));
            dicePane.add(lblHold[i],i,1);
            GridPane.setMargin(lblHold[i], new Insets(0,0,0,25));
            cbxHolds[i].setDisable(true);
        }
        // add lblThrowCount and btnThrow
        dicePane.add(btnThrow, 4, 3);
        btnThrow.setOnAction(event -> btnThrowAction());
        dicePane.add(lblThrowCount,2,3);
        dicePane.add(txfThrowcount,3,3);
        txfThrowcount.setEditable(false);
        GridPane.setMargin(lblThrowCount,new Insets(0,0,0,15));
        txfThrowcount.setMaxWidth(25);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int width = 50; // width of the text fields

        // add labels for results
        for (int i = 0; i < 15; i++){
            scorePane.add(new Label(strings[i]),0,i);
            txfResults.add(i, new TextField());
            scorePane.add(txfResults.get(i),1, i);
            txfResults.get(i).setPrefWidth(40);
            txfResults.get(i).setEditable(false);
            txfResults.get(i).setFocusTraversable(false);
            txfResults.get(i).setOnMouseClicked(event -> onMouseClick(event));
        }
        // add txfResults,
        // add labels and text fields for sums, bonus and total.
        scorePane.add(txfSumSame,3,5);
        txfSumSame.setEditable(false);
        txfSumSame.setMaxWidth(40);
        txfSumSame.setFocusTraversable(false);
        scorePane.add(new Label("Sum:"),2,5);
        scorePane.add(txfBonus,3, 6);
        txfBonus.setEditable(false);
        txfBonus.setFocusTraversable(false);
        scorePane.add(new Label("Bonus:"),2,6);
        txfBonus.setMaxWidth(40);
        scorePane.add(new Label("Sum:"),2,13);
        scorePane.add(txfSumOther,3, 13);
        txfSumOther.setMaxWidth(40);
        txfSumOther.setFocusTraversable(false);
        scorePane.add(new Label("Total:"),2,14);
        scorePane.add(txfTotal,3,14);
        txfTotal.setMaxWidth(40);
        txfTotal.setFocusTraversable(false);


    }

    // -------------------------------------------------------------------------

    // Create an action method for btnThrow's action.
    // Hint: Create small helper methods to be used in the action method.
    public void btnThrowAction(){
        for (int i = 0; i < cbxHolds.length; i++){
            if (cbxHolds[i].isDisabled() && !cbxHolds[i].isSelected()){
                cbxHolds[i].setDisable(false);
            }
        }
        dice.throwDice(hold);
        int[] values = dice.getValues();
        for (int i = 0;i < values.length; i++){
            txfValues[i].setText("" + values[i]);
            txfValues[i].setFont(Font.font(30));
            txfValues[i].setAlignment(Pos.CENTER);
            txfValues[i].setFocusTraversable(false);
            if (dice.getThrowCount() >= 3){
                btnThrow.setDisable(true);
            }
        }
        txfThrowcount.setText(""+dice.getThrowCount());
        setResults();
    }

    public void holdPressAction(int i){
        if (dice.getThrowCount() != 0){
            hold[i] = true;
            cbxHolds[i].setDisable(true);
        }

    }
    public void setResults(){
        int[] results = dice.getResults();
        for (int i = 0; i < 15; i++){
            if (!txfResults.get(i).isDisabled())
            txfResults.get(i).setText(""+results[i]);
        }
    }

    public void resetFields(){
        dice.resetThrowCount();
        btnThrow.setDisable(false);
        for (int i = 0; i < hold.length; i++){
            cbxHolds[i].setDisable(false);
            cbxHolds[i].setSelected(false);
            hold[i] = false;
            txfValues[i].setText("");
        }
        for (int i = 0; i < 15; i++){
            if (!txfResults.get(i).isDisabled()){
                txfResults.get(i).setText("");
            }
        }
        txfThrowcount.setText(""+dice.getThrowCount());
    }
    public void sumAdd(){
        int temp = 0;
        int sumSame = 0;
        int sumOther = 0;
        int sumTotal = 0;
        for (int i = 0; i < 6; i++){
            if (txfResults.get(i).isDisabled()){
                sumSame += Integer.valueOf(txfResults.get(i).getText());
            }
        }
        if (sumSame > 62){
            txfBonus.setText("50");
            sumSame += 50;
        }
        for (int i = 6; i < 15; i++){
            if (txfResults.get(i).isDisabled()){
                sumOther += Integer.valueOf(txfResults.get(i).getText());
            }
        }
        sumTotal = sumSame + sumOther;
        txfSumSame.setText(String.valueOf(sumSame));
        txfSumOther.setText(String.valueOf(sumOther));
        txfTotal.setText(String.valueOf(sumTotal));
    }
    public void ceckBoxDisable(){
        for (int i = 0; i < cbxHolds.length; i++){
            cbxHolds[i].setDisable(true);
        }
    }

    // -------------------------------------------------------------------------

    // Create a method for mouse click on one of the text fields in txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.
    public void onMouseClick(MouseEvent event){
        TextField txf = (TextField) event.getSource();
        if (dice.getThrowCount() != 0){
            txf.setDisable(true);
            sumAdd();
            resetFields();
            ceckBoxDisable();
        }
    }
}
