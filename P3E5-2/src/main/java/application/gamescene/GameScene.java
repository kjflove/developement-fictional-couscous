package application.gamescene;

import application.Bootstrap;
import application.GameType;
import application.gamescene.components.Ball;
import application.gamescene.components.Player;
import application.gamescene.factories.BlocksFactory;
import application.gamescene.factories.LevelFactory;
import application.gamescene.handler.AnimationHandler;
import application.gamescene.handler.KeyHandler;
import application.gamescene.interfaces.Score;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

/**
 * Class description ...
 * Included in application.gamescene
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 27. Mai 2017
 */
public class GameScene extends Scene {

    private Ball ball;
    private Player player;
    private BlocksFactory blocksFactory;
    private Score score;

    private Pane root;
    private Bootstrap bt;

    // handlers
    private AnimationHandler animationHandler;
    private KeyHandler keyHandler;

    public GameScene(Pane root, double width, double height, Bootstrap bt) {
        super(root, width, height);
        this.score = new Score();
        this.root = root;
        this.bt = bt;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL levelText = classloader.getResource("level1.txt");
        Image image = new Image(classloader.getResourceAsStream("image.png"));
        LevelFactory factory;
        root.setBackground(new Background(new BackgroundImage(image, null, null, null, new BackgroundSize(600,600, false, false, false, false))));
        try {
            factory = new LevelFactory(levelText, this);
            this.ball = factory.b;
            this.player = factory.p;
            this.blocksFactory = factory.bf;
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.root.getChildren().addAll(this.player, this.ball);
        this.root.getChildren().addAll(this.blocksFactory.blocks);
        this.root.getChildren().add(this.score);

        this.animationHandler = new AnimationHandler(this);
        this.keyHandler = new KeyHandler(this);
    }

    public void animate(ActionEvent e){
        if(getStatusProperty().get() == GameType.RUNNING){
            this.ball.Update();
        }
    }

    public SimpleObjectProperty<GameType> getStatusProperty(){
        return bt.status;
    }

    public Ball getBall() {
        return ball;
    }

    public Player getPlayer() {
        return player;
    }

    public BlocksFactory getBlocksFactory() {
        return blocksFactory;
    }

    public Score getScore() {
        return score;
    }

    public Pane getPane() {
        return root;
    }

    public void restart(){
        this.root.getChildren().removeAll(this.player, this.ball, this.score);
        this.root.getChildren().removeAll(this.blocksFactory.blocks);

        this.score = new Score();

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL im = classloader.getResource("level2.txt");
        LevelFactory factory;

        try {
            factory = new LevelFactory(im, this);
            this.ball = factory.b;
            this.player = factory.p;
            this.blocksFactory = factory.bf;
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.root.getChildren().addAll(this.player, this.ball);
        this.root.getChildren().addAll(this.blocksFactory.blocks);
        this.root.getChildren().add(this.score);

        this.animationHandler.stop();
        this.animationHandler = new AnimationHandler(this);
        this.keyHandler = new KeyHandler(this);
    }
}
