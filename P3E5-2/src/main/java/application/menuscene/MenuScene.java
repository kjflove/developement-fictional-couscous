package application.menuscene;

import application.Bootstrap;
import application.gamescene.factories.LevelFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;

/**
 * Class description ...
 * Included in application.menuscene
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 27. Mai 2017
 */
public class MenuScene extends Scene {

    private IMenu main;
    private Pane pane;

    public MenuScene(StackPane pane, double x, double y, Bootstrap bt){
        super(pane, x, y);
        this.pane = pane;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Image image = new Image(classloader.getResourceAsStream("image.png"));
        LevelFactory factory;
        this.pane.setBackground(new Background(
                new BackgroundImage(image, null, null, null,
                        new BackgroundSize(600,600, false, false, false, false)
                )
        ));

        this.main = new MainMenu(bt);
        this.pane.getChildren().addAll(main.getAllChildren());
    }
}
