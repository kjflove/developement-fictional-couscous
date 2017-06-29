package arkaniod.views.components;

import arkaniod.models.GameStore;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Class description ...
 * Included in arkaniod.models
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Mai 2017
 */
public class PlayerBar extends Rectangle {

    private final double EPSILON = 2;
    private double posX;
    private GameStore myStore;
    private double speedMultiplier = 10;

    public PlayerBar(double x, double y, GameStore myStore) {
        super(x, y, 100, 10);
        this.myStore = myStore;
        this.posX = x;
        super.setFill(Color.DARKGRAY);
    }

    public void movePlayerBar() {
        double dist = this.getX() - posX;

        if (posX - this.getX() > 0)
            this.setX(this.getX() + speedMultiplier);
        else if (posX - this.getX() < 0)
            this.setX(this.getX() - speedMultiplier);
    }

    public void setPosX(double a) {
        if (myStore.myScene.getWidth() > (posX + this.getWidth() + a)
                && (this.getX() + a) > 0) {
            this.posX += a;
        }
    }

}
