package application.statusscene;

import application.Bootstrap;
import application.GameType;
import application.gamescene.GameScene;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Class description ...
 * Included in application.statusscene
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 28. Mai 2017
 */
public class StatusScene extends Scene {

    private Bootstrap bs;
    private GameType gameType;

    public StatusScene(Parent root, double width, double height, Bootstrap bt, GameType gt) {
        super(root, width, height);
        this.bs = bt;
        this.gameType = gt;
        if(gameType.equals(GameType.LOSE)){

        }else if(gameType.equals(GameType.WIN)){

        }
    }
}
