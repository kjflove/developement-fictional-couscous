package application.views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;

/**
 * Class description ...
 * Included in application.views
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 29. Apr 2017
 */
public abstract class IPublicView<T> {

    public static Map<String, IPublicView> allRegisteredViews = new HashMap<>();

    Map<String, Control> listOfButtons= new HashMap<>();
    private Scene scene;
    private Stage primaryStage;

    public IPublicView(Scene myScene, String sceneName, Stage primStage) {
        scene = myScene; primaryStage = primStage;
        allRegisteredViews.put(sceneName, this);
    }

    public Map<String, Control> getListOfButtons() {
        return listOfButtons;
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
