package arkaniod.models;

import arkaniod.GameEntry;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableDoubleValue;

/**
 * Class description ...
 * Included in arkaniod.models
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 20. Mai 2017
 */
public class BallModel {

    private final float speed = 7.5f;
    private double currentAngle;
    private ObservableDoubleValue velocityX, velocityY, x, y;

    public BallModel() {
        velocityY = new SimpleDoubleProperty();
        velocityX = new SimpleDoubleProperty();
        x = new SimpleDoubleProperty();
        y = new SimpleDoubleProperty();
    }

    private static double randomBetween(double low, double high) {
        return (Math.random() * (high - low)) + low;
    }

    public void velocityUpdateY(ChangeListener<? super Number> listener) {
        velocityY.addListener(listener);
    }

    public void velocityUpdateX(ChangeListener<? super Number> listener) {
        velocityX.addListener(listener);
    }

    public void launch() {
        currentAngle = -randomBetween(45, 125);
        velocityX = Math.cos(currentAngle) * speed;
        velocityY = Math.sin(currentAngle) * speed;
        System.out.println();
    }

    public void executeMoveLogic() {
        CollidingCheck(velocityX.get() + x.get(), velocityY.get() + y.get());

        double nextX = velocityX.get() + x.get();
        double nextY = velocityY.get() + x.get();

        y. (nextX);
        this.setCenterY(nextY);
    }

    private void CollidingCheck(double x, double y) {
        // Bounces against walls :)
        if (x <= 0 || x >= GameEntry.main.getWidth()) {
            this.velocityX *= -1;
        } else if (y <= 0 || y >= GameEntry.main.getHeight()) {
            this.velocityY *= -1;
        }

        // bounces against the playerbar
        if (y >= myStore.player.getY() &&
                (myStore.player.getX() <= x && x <= myStore.player.getX() + myStore.player.getWidth())) {
            this.velocityY *= -1;
        }
    }
}
