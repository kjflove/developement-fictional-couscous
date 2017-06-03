package application.menuscene;

import javafx.scene.Node;

import java.util.Collection;

/**
 * Class description ...
 * Included in application.menuscene
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 27. Mai 2017
 */
public interface IMenu {
    Collection<Node> getAllChildren();
    String getName();
}
