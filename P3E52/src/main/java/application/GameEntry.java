package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 23. Mai 2017
 */
public class GameEntry extends Application {

    private Pane pane = new Pane();
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.scene = new Scene(pane, 600, 600);
        new Bootstrap(this.scene, this.pane);

        primaryStage.setScene(this.scene);
        primaryStage.setTitle("Arkaniod v0.1.2a");
        primaryStage.show();
    }
}
