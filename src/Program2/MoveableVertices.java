package Program2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.text.Text;



public class MoveableVertices extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();


        Circle c1 = new Circle(40, 40, 10, Color.TRANSPARENT);
        c1.setStroke(Color.GREEN);

        Circle c2 = new Circle(120, 150, 10, Color.TRANSPARENT);
        c2.setStroke(Color.RED);

        Text text = new Text();
        Line line = new Line();
        lineUpdate(line, c1, c2, text);


        c1.setOnMouseDragged(event -> {
            c1.setCenterX(event.getX());
            c1.setCenterY(event.getY());
            lineUpdate(line, c1, c2, text);
        });

        c2.setOnMouseDragged(event -> {
            c2.setCenterX(event.getX());
            c2.setCenterY(event.getY());
            lineUpdate(line, c1, c2, text);
        });
        pane.getChildren().addAll(line, c1, c2, text);
        primaryStage.setScene(new Scene(pane,400,400));
        primaryStage.show();


    }
    private void lineUpdate(Line line, Circle c1, Circle c2, Text txtPoint) {

        double x1 = c1.getCenterX();
        double y1 = c1.getCenterY();
        double x2 = c2.getCenterX();
        double y2 = c2.getCenterY();
        double radius = c1.getRadius();

        double d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        line.setStartX(c1.getCenterX());
        line.setStartY(c1.getCenterY());
        line.setEndX(c2.getCenterX());
        line.setEndY(c2.getCenterY());
        double lineCenterX = (c1.getCenterX() + c2.getCenterX())/2;
        double lineCenterY = (c1.getCenterY() + c2.getCenterY())/2;

        txtPoint.setText(String.format("%.2f",d));
        txtPoint.setX(lineCenterX);
        txtPoint.setY(lineCenterY);
    }
}
