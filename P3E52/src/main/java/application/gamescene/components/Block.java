package application.gamescene.components;

import javafx.geometry.Point2D;
import javafx.scene.shape.Rectangle;


/**
 * Class description ...
 * Included in application.gamescene.components
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 24. Mai 2017
 */
public class Block extends Rectangle {

    public Block(Point2D pos, double width, double height){
        super(pos.getX(), pos.getY(), width, height);
    }

}
