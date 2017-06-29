
import firework.MovingEllipse;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MoveIt extends Application {

    private final Random random = new Random();
    private final Button bt = new Button("Restart");
    private List<MovingEllipse> ovals = new ArrayList<MovingEllipse>();
    private Group group = new Group();  //root node for the play window
    private Pane pane;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final BorderPane borderPane;
        final Scene scene;

        primaryStage.setTitle("Ellipse & AnimationTimer Example");
        //create a pane for a group with all moving objects
        pane = new Pane(group);
        pane.setPrefSize(500, 500);
        pane.setStyle("-fx-background-color: black;");
        pane.setOnMousePressed((e) -> {
            ovals.clear(); //clear List with references
            group.getChildren().clear(); //clear all moving objectsss
            for (int i = 0; i < 360; i++) {
                generate(Color.ANTIQUEWHITE, e.getX(), e.getY(), 2.0, i);
            }
        });

        //create a restart button
        bt.setOnAction((e) -> {
            ovals.clear(); //clear List with references
            group.getChildren().clear(); //clear all moving objects
        });

        //create the main window lauout
        borderPane = new BorderPane();
        borderPane.setTop(bt);
        borderPane.setCenter(pane);
        scene = new Scene(borderPane, 500, 500);
        primaryStage.setScene(scene);


        //set pane autoresisable
        scene.widthProperty().addListener((observableValue, oldSceneWidth, newSceneWidth) -> {
            System.out.println("Width: " + newSceneWidth);
            pane.setPrefWidth(scene.getWidth());
        });


        scene.heightProperty().addListener((observableValue, oldSceneHeight, newSceneHeight) -> {
            System.out.println("Height: " + newSceneHeight);
            pane.setPrefHeight(scene.getHeight());
        });

        primaryStage.show();

        new AnimationTimer() { //animate all circles
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                // each 28 milliseconds, both in nanoseconds
                if (now - lastUpdate >= 280 * 100_000 && ovals.size() > 0) {
                    int angle = 360 / ovals.size();
                    int i = 1;
                    ovals.forEach(e -> e.moveEllipse());
                    lastUpdate = now;
                }
            }
        }.start();
    }

    private void generate(Color c, Double x, Double y, double radius, double angle) {
        Ellipse localCircle = new Ellipse(x, y, radius, radius);
        localCircle.setFill(c);
        ovals.add(new MovingEllipse(localCircle, random.nextDouble(), random.nextDouble(), angle, pane));
        group.getChildren().add(localCircle); //add obect to the group

    }
}
