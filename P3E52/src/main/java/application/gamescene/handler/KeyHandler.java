package application.gamescene.handler;

import application.GameType;
import application.Bootstrap;
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

    private Bootstrap bt;

    public KeyHandler(Bootstrap bt){
        this.bt = bt;
        bt.getScene().setOnKeyPressed(this::onKeyPressed);
        bt.getScene().setOnKeyReleased(this::onKeyReleased);
    }

    public void onKeyPressed(KeyEvent e){
        switch (e.getCode()){
            case SPACE:
                bt.setStatus(GameType.RUNNING);
                break;
            case LEFT:
                bt.getPlayer().rectangleVelocity.set(-this.bt.getPlayer().SPEED);
                break;
            case RIGHT:
                bt.getPlayer().rectangleVelocity.set(this.bt.getPlayer().SPEED);
                break;
        }
    }

    public void onKeyReleased(KeyEvent e){
        switch (e.getCode()){
            case LEFT:
            case RIGHT:
                bt.getPlayer().rectangleVelocity.set(0);
                break;
        }
    }
}
