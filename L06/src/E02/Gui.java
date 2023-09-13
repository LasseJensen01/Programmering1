package E02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		GridPane root = this.initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(200, 200);
		pane.add(canvas, 0, 0);
		this.drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		// Replace the statement here with your code.
		int x = 100;
		int y = 100;
		int z = 10;
		int a = 20;
		int b = 40;
		int c = 60;
		int d = 80;
		int e = 100;
		int f = 120;
		int g = 140;
		int h = 160;
		int i = 180;
		gc.strokeLine(x , y ,a , z);
		gc.strokeLine(x , y ,b , z);
		gc.strokeLine(x , y ,c , z);
		gc.strokeLine(x , y ,d , z);
		gc.strokeLine(x , y ,e , z);
		gc.strokeLine(x , y ,f , z);
		gc.strokeLine(x , y ,g , z);
		gc.strokeLine(x , y ,h , z);
		gc.strokeLine(x , y ,i , z);
	}
}
