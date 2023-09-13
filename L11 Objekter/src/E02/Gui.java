package E02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

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
		drawTriangle(pane);
		drawRect(pane);
		drawRect2(pane);
		drawCircle(pane);
		drawLine(pane);
	}
	private void drawCircle(Pane pane){
		Circle circle = new Circle();
		circle.setRadius(40);
		circle.setCenterX(150);
		circle.setCenterY(25);
		circle.setFill(Color.YELLOW);
		circle.setStroke(Color.BLACK);
		pane.getChildren().add(circle);

	}
	private void drawRect(Pane pane){
		Rectangle rect = new Rectangle();
		rect.setWidth(75);
		rect.setHeight(100);
		rect.setX(75);
		rect.setY(75);
		rect.setFill(Color.RED);
		rect.setStroke(Color.BLACK);
		pane.getChildren().add(rect);
	}
	private void drawRect2(Pane pane){
		Rectangle rect = new Rectangle();
		rect.setWidth(25);
		rect.setHeight(25);
		rect.setX(90);
		rect.setY(110);
		rect.setFill(Color.BLACK);
		rect.setStroke(Color.BLACK);
		pane.getChildren().add(rect);
	}
	private void drawTriangle(Pane pane){
		Polygon triangle = new Polygon(75,75, 37.5+75,30, 150,75);
		triangle.setFill(Color.GREEN);
		triangle.setStroke(Color.BLACK);
		pane.getChildren().add(triangle);
	}
	private void drawLine(Pane pane){
		Line line = new Line();
		line.setStartX(75);
		line.setStartY(175);
		line.setEndX(200);
		line.setEndY(175);
		line.setFill(Color.BLACK);
		pane.getChildren().add(line);
	}
}
