package arkaniod.models;

import arkaniod.views.GameStatus;
import arkaniod.views.InsertCoin;
import arkaniod.views.PauseMenu;
import arkaniod.views.components.Ball;
import arkaniod.views.components.PlayerBar;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.InputStream;

/**
 * Class description ...
 * Included in arkaniod.models
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Mai 2017
 */
public class GameStore {

    public PlayerBar player;
    public Ball ball;
    public InsertCoin coin;
    public GameStatus currentState = GameStatus.GAME_INACTIVE;
    public Scene myScene;
    public Group group;
    public PauseMenu pauseMenu;
    public Pane pane;

    public GameStore(Scene scene, Group group, Pane pane) {
        double x = scene.getWidth() * 0.5 - (100 / 2);
        double y = scene.getHeight() * 0.9 - (10 / 2);
        double rad = 10;

        this.pane = pane;
        this.group = group;
        this.myScene = scene;
        this.player = new PlayerBar(x, y, this);
        this.ball = new Ball(scene.getWidth() * 0.5, y - rad, rad, this);
        this.pauseMenu = new PauseMenu(this);

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Image im = new Image(classloader.getResourceAsStream("image.png"));
        InputStream in = classloader.getResourceAsStream("insert.png");

        BackgroundImage myBI = new BackgroundImage(im, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));

        this.coin = new InsertCoin(scene, this, in);
    }

}
