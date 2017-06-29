package firework;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Class description ...
 * Included in firework
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 12. May 2017
 */
public class MovingEllipse {

    private double speed;
    private final double GRAVITY = 0.05;

    private double velocityX = 0;
    private double velocityY = 0;

    private double lifeSpan = 10;

    private Pane pane;
    private Ellipse c; //reference on a circle

    public MovingEllipse(Ellipse c, double dx, double dy, double angle, Pane pane) {
        this.c = c;
        this.speed = randomBetween(1,3);
        this.velocityX = Math.cos(angle) * speed;
        this.velocityY = Math.sin(angle) * speed;
        this.pane = pane;
    }

    private static double root(double num, double root) {
        return Math.pow(Math.E, Math.log(num) / root);
    }

    private static double randomBetween(double low, double high) {
        return (Math.random() * (high - low)) + low;
    }

    public void moveEllipse(){

        if(speed > 0){
             speed -= 0.015 * (Math.random()*5);
        }

        c.setFill(new Color(Math.random(), Math.random(), Math.random(), visibility(lifeSpan)));

        if (c.getCenterX() <= 0 && velocityX < 0 || c.getCenterX() > pane.getWidth() && velocityY < 0 && velocityX> 0) {
            this.velocityX *= -.90;
        } else if (c.getCenterY() <= 0 && velocityY < 0 || c.getCenterY() >= pane.getHeight() && velocityY > 0) {
            this.velocityY *= -.90;
        }

        this.velocityY += GRAVITY;

        this.c.setCenterX(velocityX + c.getCenterX());
        this.c.setCenterY(velocityY + c.getCenterY());
        lifeSpan -= 0.01 * Math.random() * 3;
    }

    private double visibility(double lifeSpan) {
        double r = root(lifeSpan, 2);
        return (r > 1) ? 1 : r;
    }
}
