package application.gamescene.components;

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
public class Block extends Rectangle implements GameObject {

    private boolean deleted = false;

    public Block(Point2D pos, double width, double height){
        super(pos.getX(), pos.getY(), width, height);
        this.setFill(Color.WHITE);
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

    public void deletingBlock(){
        this.deleted = true;
    }

    public boolean isDeleted(){
        return this.deleted;
    }
}
