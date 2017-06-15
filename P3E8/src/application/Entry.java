package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 * Class description ...
 * Included in application
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Jun 2017
 */
public class Entry extends Application {

    private Button redB = new Button("red"),
            greenB = new Button("green"),
            blinkB = new Button("blink");

    private Ellipse red = new Ellipse(20, 20),
            yellow = new Ellipse(20, 20),
            green = new Ellipse(20, 20);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 200, 400);


        VBox lights = new VBox();
        HBox buttons = new HBox();

        lights.getChildren().addAll(red, yellow, green);
        buttons.getChildren().addAll(redB, greenB, blinkB);
        StateMachine sm = new StateMachine(red, yellow, green);

        redB.setOnAction((e) -> {
            sm.setCurrentStatus(TrafficLight.RED);
        });

        greenB.setOnAction((e) -> {
            sm.setCurrentStatus(TrafficLight.GREEN);
        });

        blinkB.setOnAction((e) -> {
            sm.setCurrentStatus(TrafficLight.BLINKING);
        });


        Thread k = new Thread(sm);
        k.start();

        lights.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);
        lights.setSpacing(10);
        lights.setPadding(new Insets(0, 20, 10, 20));

        pane.setBottom(buttons);
        pane.setCenter(lights);

        primaryStage.setScene(scene);
        primaryStage.setTitle("traffic light");
        primaryStage.show();
    }


}
