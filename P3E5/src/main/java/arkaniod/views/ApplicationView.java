package arkaniod.views;

import arkaniod.controller.AnimationController;
import arkaniod.controller.KeyController;
import arkaniod.controller.MusicController;
import arkaniod.models.GameStore;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Class description ...
 * Included in arkaniod.views
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 20. Mai 2017
 */
public class ApplicationView extends Application {

    public static Scene main;
    private Group group = new Group();

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application tso begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane x = new Pane(group);
        // x.setStyle("-fx-background-color: black;");
        main = new Scene(x, 900, 650);

        GameStore myStore = new GameStore(main, group, x);

        group.getChildren().addAll(myStore.coin);
        main.setOnKeyPressed(new KeyController(myStore));
        new AnimationController(myStore);

        primaryStage.setScene(main);
        MusicController.runMusic();
        primaryStage.setOnCloseRequest((e) -> {
            MusicController.stopMusic();
            System.exit(0);
        });

        primaryStage.setTitle("Arkaniod 2000");
        primaryStage.show();
    }
}
