package application.gamescene.components;

import application.Bootstrap;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Point2D;
import javafx.scene.shape.Ellipse;



/**
 * Class description ...
 * Included in application.gamescene.components
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 23. Mai 2017
 */
public class Ball extends Ellipse {

    private double velocityX = 0;
    private double velocityY = 0;
    private final int SPEED = 5;

    private ObjectProperty<Point2D> pos;
    private Bootstrap bt;

    public Ball(Point2D pos, Bootstrap bt){
        super(pos.getX(), pos.getY(), 10, 10);
        this.centerYProperty().set(pos.getY());
        this.centerXProperty().set(pos.getX());
        this.bt = bt;
        double angle = Math.floor(Math.random() * 125) + 45;
        velocityX = Math.cos(angle);
        velocityY = Math.sin(angle);
        this.pos = new SimpleObjectProperty<>(pos);
        this.pos.addListener(((observable, oldValue, newValue) -> {
            this.centerXProperty().set(newValue.getX());
            this.centerYProperty().set(newValue.getY());
        }));
    }

    public void Update() {
        // check if colliding
        if(checkForCollisionX(this.pos.getValue().getX(), this.pos.getValue().getY())){
            velocityX *= -1;
        }

        if(checkForCollisionY(this.pos.getValue().getX(), this.pos.getValue().getY())){
            velocityY *= -1;
        }

        this.pos.setValue(this.pos.getValue().add(new Point2D(velocityX * SPEED, velocityY * SPEED)));
    }

    private boolean checkForCollisionX(double x, double y){
        boolean border = (x <= 0) || (x >= bt.getWidth());
        //boolean player = (x >= bt.getPlayer().getX() || x <= bt.getPlayer().getX() + bt.getPlayer().getWidth())
                //&& (y >= bt.getPlayer().getY() && y <= bt.getPlayer().getY() + bt.getPlayer().getHeight());
        return border;
    }

    private boolean checkForCollisionY(double x, double y){
        // if hitting border
        boolean border = (y <= 0) || (y >= bt.getHeight());
        boolean player = (y >= bt.getPlayer().getY()-10)
                && (x >= bt.getPlayer().getX() && x <= bt.getPlayer().getX() + bt.getPlayer().getWidth());

        if(player) bt.getScore().addScoreCount(5);
        return border || player;
    }

}
