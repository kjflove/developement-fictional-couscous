package application;

import application.gamescene.components.Ball;
import application.gamescene.factories.BlocksFactory;
import application.gamescene.components.Player;
import application.gamescene.factories.LevelFactory;
import application.gamescene.handler.AnimationHandler;
import application.gamescene.handler.KeyHandler;
import application.gamescene.interfaces.Score;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 23. Mai 2017
 */
public class Bootstrap {

    private Ball ball;
    private Player player;
    private BlocksFactory blocks;
    private Score score;

    private Scene scene;
    private Pane pane;

    private AnimationHandler animationHandler;
    private KeyHandler keyHandler;

    private GameType status = GameType.INACTIVE;

    public Bootstrap(Scene scene, Pane pane) {
        this.scene = scene;
        this.pane = pane;

        this.score = new Score();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL im = classloader.getResource("level2.txt");
        LevelFactory factory;

        try {
            factory = new LevelFactory(im, this);
            this.ball = factory.b;
            this.player = factory.p;
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.pane.getChildren().addAll(this.player, this.ball);
        this.pane.getChildren().addAll(BlocksFactory.blocks);
        this.pane.getChildren().add(this.score);
        this.animationHandler = new AnimationHandler(this);
        this.keyHandler = new KeyHandler(this);

    }

    public void disableNode(Node e){
        this.pane.getChildren().remove(e);
    }

    public void enableNode(Node e){
        this.pane.getChildren().add(e);
    }

    public double getHeight(){
        return this.scene.getHeight();
    }

    public double getWidth(){
        return this.scene.getWidth();
    }

    public void animate(ActionEvent e){
        if(status == GameType.RUNNING){
            this.ball.Update();
        }
    }

    public GameType getStatus() {
        return status;
    }

    public void setStatus(GameType status) {
        this.status = status;
    }

    public Scene getScene() {
        return scene;
    }

    public Player getPlayer() {
        return player;
    }

    public Score getScore() {
        return score;
    }
}
