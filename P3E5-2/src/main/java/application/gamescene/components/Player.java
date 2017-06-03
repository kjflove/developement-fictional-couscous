package application.gamescene.components;

import application.GameType;
import application.gamescene.GameScene;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Class description ...
 * Included in application.gamescene.components
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 24. Mai 2017
 */
public class Player extends Rectangle implements GameObject {

    private GameScene gameScene;
    private static int width = 100, height = 10;
    public final DoubleProperty rectangleVelocity = new SimpleDoubleProperty();
    public final int SPEED = 300;

    public Player(Point2D pos, GameScene gameScene){
        super(pos.getX() - width/2, pos.getY() - height/2, width, height);
        this.setFill(Color.GHOSTWHITE);

        this.gameScene = gameScene;
        new PlayerAnimator(this).start();
    }

    @Override
    public double right() {
        return getX() + getWidth();
    }

    @Override
    public double left() {
        return getX();
    }

    @Override
    public double top() {
        return getY();
    }

    @Override
    public double bottom() {
        return getY() + getHeight();
    }

    private class PlayerAnimator extends AnimationTimer {

        final LongProperty lastUpdateTime = new SimpleLongProperty();
        private Player p;
        public PlayerAnimator(Player p){
            this.p = p;
        }

        @Override
        public void handle(long timestamp) {
            if (lastUpdateTime.get() > 0 && gameScene.getStatusProperty().get() == GameType.RUNNING) {
                final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0 ;
                final double deltaX = elapsedSeconds * rectangleVelocity.get();
                final double oldX = p.getX();
                final double newX = Math.max(0, Math.min(gameScene.getWidth(), oldX + deltaX));
                p.setX(newX);
            }
            lastUpdateTime.set(timestamp);
        }
    }
}
