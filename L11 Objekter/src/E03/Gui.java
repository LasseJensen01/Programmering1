package E03;

import javafx.application.Application;
import javafx.css.Size;
import javafx.scene.Scene;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
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
		drawCircle(pane);
		drawLine(pane);
		drawPolygon(pane);
		drawEyes(pane);
	}
private void drawLine(Pane pane){
		Line line = new Line();
		line.setStartX(180);
		line.setStartY(80);
		line.setEndX(200);
		line.setEndY(60);
		pane.getChildren().add(line);
		Line line2 = new Line();
		line2.setStartX(120);
		line2.setStartY(80);
		line2.setEndX(100);
		line2.setEndY(60);
		pane.getChildren().add(line2);

}
	private void drawCircle(Pane pane) {
		int radius = 40;
		int y = 150;
		for (int i = 0; i < 3; i++) {
			Circle circle1 = new Circle();
			circle1.setRadius(radius);
			circle1.setCenterX(150);
			circle1.setCenterY(y);
			circle1.setFill(Color.WHITE);
			circle1.setStroke(Color.BLACK);
			pane.getChildren().add(circle1);
			y = y-radius;
			radius = radius - 10;
			y = y - radius;
		}
	}
	private void drawPolygon(Pane pane){
		Polygon carrot = new Polygon(150, 30, 150, 35, 140, 32.5);
		carrot.setFill(Color.ORANGE);
		carrot.setStroke(Color.BLACK);
		pane.getChildren().add(carrot);
	}
	private void drawEyes(Pane pane){
		int x = 145;
		for (int i = 0; i < 2;i++){
			Circle circle = new Circle();
			circle.setRadius(5);
			circle.setCenterX(x);
			circle.setCenterY(25);
			circle.setFill(Color.BLACK);
			pane.getChildren().add(circle);
			x += 10;
		}
	}
}

