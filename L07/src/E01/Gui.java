package E01;

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
		gc.strokeLine(10, 180, 190, 180);
		gc.strokeLine(190,180,185,175 );
		gc.strokeLine(190,180,185,185 );
		int x = 18;
		int y = 175;
		int y2 = 185;
		int a = 0;
		int a2 = 0;
		for(int i = 1; i <= 11; i++){
			if (i == 1|| i == 6 || i == 11){
				a = 5;
				a2 = -5;
				}
			gc.strokeLine(x,y+a2,x,y2+a);
			a = 0;
			a2 = 0;
			x += 16;
		}
		}
	}