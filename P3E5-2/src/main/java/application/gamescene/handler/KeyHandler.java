package application.gamescene.handler;

import application.GameType;
import application.gamescene.GameScene;
import javafx.scene.input.KeyEvent;


/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 23. Mai 2017
 */
public class KeyHandler {

    private GameScene gameScene;

    public KeyHandler(GameScene gameScene){
        this.gameScene = gameScene;
        gameScene.setOnKeyPressed(this::onKeyPressed);
        gameScene.setOnKeyReleased(this::onKeyReleased);
    }

    public void onKeyPressed(KeyEvent e){
        switch (e.getCode()){
            case LEFT:
                gameScene.getPlayer().rectangleVelocity.set(-this.gameScene.getPlayer().SPEED);
                break;
            case RIGHT:
                gameScene.getPlayer().rectangleVelocity.set(this.gameScene.getPlayer().SPEED);
                break;
            case ESCAPE:
                gameScene.getStatusProperty().set(GameType.INACTIVE);
        }
    }

    public void onKeyReleased(KeyEvent e){
        switch (e.getCode()){
            case LEFT:
            case RIGHT:
                gameScene.getPlayer().rectangleVelocity.set(0);
                break;
        }
    }
}
