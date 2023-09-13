package E04;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane, 300, 200);
		this.initContent(pane);
		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	// ------------------------------------------------------------------------
	private void initContent(Pane pane) {

	}
	private void drawText(Pane pane){
		String name = "Lasse";
		Text text = new Text(name);


	}
}

