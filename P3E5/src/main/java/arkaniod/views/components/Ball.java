package arkaniod.views.components;

import arkaniod.GameEntry;
import arkaniod.models.GameStore;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Class description ...
 * Included in arkaniod.models
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Mai 2017
 */
public class Ball extends Ellipse {

    private final float speed = 7.5f;
    private double currentAngle;
    private GameStore myStore;
    private double velocityX, velocityY;

    /**
     * Creates an instance of Ellipse of the given position and size.
     *
     * @param centerX the horizontal position of the center of the ellipse in pixels
     * @param centerY the vertical position of the center of the ellipse in pixels
     * @param rad     the radius of the ellipse in pixels
     */
    public Ball(double centerX, double centerY, double rad, GameStore myStore) {
        super(centerX, centerY, rad, rad);
        super.setFill(Color.RED);
        this.myStore = myStore;
    }

    private static double randomBetween(double low, double high) {
        return (Math.random() * (high - low)) + low;
    }

    public void launch() {
        currentAngle = -randomBetween(45, 125);
        velocityX = Math.cos(currentAngle) * speed;
        velocityY = Math.sin(currentAngle) * speed;
        System.out.println();
    }

    public void executeMoveLogic() {
        CollidingCheck(velocityX + this.getCenterX(), velocityY + this.getCenterY());

        double nextX = velocityX + this.getCenterX();
        double nextY = velocityY + this.getCenterY();

        this.setCenterX(nextX);
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
