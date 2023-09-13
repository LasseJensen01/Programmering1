package E08;

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
		int x = 25;
		int y = 125;
		double h = 81;
		double j = h/3;
		gc.strokeLine(x, y, x + h + h, y);
		gc.strokeLine(x,y, x + h, y - h);
		gc.strokeLine(x + h + h, y, x + h, y - h);
		drawInnerTriangels(gc, x, y, j, h);
		}
		private void drawInnerTriangels(GraphicsContext gc, int x, int y, double j, double h){
			gc.strokeLine(x + j + j, y - j - j , x + h + j, y - j - j);
			gc.strokeLine(x + h + j ,y, x + h + j + j, y - j);
			gc.strokeLine(x + j + j, y, x + j, y - j);


		}
	}
