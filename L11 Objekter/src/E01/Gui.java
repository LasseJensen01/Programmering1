package E01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.time.temporal.Temporal;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		Pane pane = new Pane();
		Scene scene = new Scene(pane,300,200);
        this.initContent(pane);
		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

		// ------------------------------------------------------------------------
	private void initContent(Pane pane){
		drawCircle(pane);
		drawRect(pane);
	}
	private void drawCircle(Pane pane){
		Color color = Color.YELLOW;
		int temp = 100;
		Circle circle = new Circle();
		circle.setRadius(40);
		circle.setCenterX(100+temp);
		circle.setCenterY(100);
		circle.setFill(color);
		circle.setStroke(Color.BLACK);
		pane.getChildren().add(circle);
	}
	private void drawRect(Pane pane){
		Color color = Color.YELLOW;
		int temp = 100;
		Rectangle rect = new Rectangle();
		rect.setHeight(40);
		rect.setWidth(80);
		rect.setX(10+temp);
		rect.setY(10);
		rect.setFill(color);
		rect.setStroke(Color.BLACK);
		pane.getChildren().add(rect);
	}
}
