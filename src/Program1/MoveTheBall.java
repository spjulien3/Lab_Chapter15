package Program1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class MoveTheBall extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MovingBallPane ballPane = new MovingBallPane(200,200,400/15);

        Button upButton = new Button("up");
        upButton.setOnAction(e -> ballPane.moveUp());
        Button DownButton = new Button("down");
        DownButton.setOnAction(e -> ballPane.moveDown());
        Button leftButton = new Button("left");
        leftButton.setOnAction(e -> ballPane.moveLeft());
        Button rightButton = new Button("right");
        rightButton.setOnAction(e -> ballPane.moveRight());


        HBox buttons = new HBox(DownButton,upButton,leftButton,rightButton);

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setBottom(buttons);
        Scene scene = new Scene(pane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();




    }
}
