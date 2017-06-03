package application.gamescene.components;

import application.GameType;
import application.Properties;
import application.gamescene.GameScene;
import application.gamescene.factories.BlocksFactory;
import application.gamescene.interfaces.Score;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.util.Iterator;


/**
 * Class description ...
 * Included in application.gamescene.components
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 23. Mai 2017
 */
public class Ball extends Ellipse implements GameObject {

    private double velocityX = .7;
    private double velocityY = .7;
    private final int SPEED = 5;

    private ObjectProperty<Point2D> pos;
    private GameScene gameScene;

    public Ball(Point2D pos, GameScene gameScene){
        super(pos.getX(), pos.getY(), 10, 10);
        this.setFill(Color.RED);
        this.centerYProperty().set(pos.getY());
        this.centerXProperty().set(pos.getX());
        this.gameScene = gameScene;

        this.pos = new SimpleObjectProperty<>(pos);
        this.pos.addListener(((observable, oldValue, newValue) -> {
            this.centerXProperty().set(newValue.getX());
            this.centerYProperty().set(newValue.getY());
        }));
    }

    public void Update() {
        if(left() < 0){
            velocityX *= -1;
        }else if(right() > Properties.SCREEN_WIDTH)
            velocityX *= -1;

        if(top() < 0)
            velocityY *= -1;
        else if(bottom() > Properties.SCREEN_HEIGHT) {
            velocityY *= -1;
            gameScene.getStatusProperty().set(GameType.INACTIVE);
        }

        this.testCollision(gameScene.getPlayer());

        Iterator<Block> it = gameScene.getBlocksFactory().blocks.iterator();
        while(it.hasNext()){
            Block e = it.next();
            testCollision(e, gameScene.getBall(), gameScene.getScore());
            if(e.isDeleted()){
                it.remove();
            }
        }

        this.pos.setValue(this.pos.getValue().add(new Point2D(velocityX * SPEED, velocityY * SPEED)));
    }

    private boolean isIntersecting(GameObject mA, GameObject mB){
        return mA.right() >= mB.left() && mA.left() <= mB.right()
                && mA.bottom() >= mB.top() && mA.top() <= mB.bottom();
    }

    private void testCollision(Player player){
        if(!isIntersecting(player, this))
            return;

        this.velocityY *= -1;
        if(this.getCenterX() < player.getX())
            this.velocityX *= -1;

    }

    private void testCollision(Block block, Ball ball, Score score){
        if(!isIntersecting(block, ball))
            return;

        gameScene.getBlocksFactory().markAsDeleted(block);
        score.addScoreCount(10);

        double overlapLeft = ball.right() - block.left();
        double overlapRight = block.right() - ball.left();
        double overlapTop = ball.bottom() - block.top();
        double overlapBottom = block.bottom() - ball.top();

        boolean ballFromLeft = overlapLeft < overlapRight;
        boolean ballFromTop = overlapTop < overlapBottom;

        double minOverlapX = ballFromLeft ? overlapLeft : overlapRight;
        double minOverlapY = ballFromTop ? overlapTop : overlapBottom;

        if(minOverlapX < minOverlapY)
            ball.velocityX *= -1;
        else
            ball.velocityY *= -1;

    }

    @Override
    public double right() {
        return this.getCenterX() + getRadiusX();
    }

    @Override
    public double left() {
        return this.getCenterX() - getRadiusX();
    }

    @Override
    public double top() {
        return this.getCenterY() - getRadiusY();
    }

    @Override
    public double bottom() {
        return this.getCenterY() + getRadiusY();
    }
}
