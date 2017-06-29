package arkaniod.controller;

import arkaniod.models.GameStore;
import arkaniod.views.GameStatus;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Mai 2017
 */
public class KeyController implements EventHandler<KeyEvent> {

    private GameStore myStore;

    public KeyController(GameStore myStore) {
        this.myStore = myStore;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(KeyEvent event) {
        KeyCode key = event.getCode();

        if (event.getCode() == KeyCode.Q) {
            System.exit(0);
        }

        switch (myStore.currentState) {
            case GAME_WON:
                onWon(key);
                break;
            case GAME_LOST:
                onLost(key);
                break;
            case GAME_RUNNING:
                onRunning(key);
                break;
            case GAME_INACTIVE:
                onInactive(key);
                break;
            case GAME_PAUSED:
                onPause(key);
                break;
        }
    }

    private void onPause(KeyCode e) {
        if (e == KeyCode.ESCAPE) {
            myStore.currentState = GameStatus.GAME_RUNNING;
            myStore.group.getChildren().remove(myStore.pauseMenu);
            myStore.pauseMenu.hidePauseMenu();
        }
    }

    private void onRunning(KeyCode e) {
        double move = myStore.myScene.getWidth() / 100;

        if (e == KeyCode.LEFT) {
            myStore.player.setPosX(-move);
        } else if (e == KeyCode.RIGHT) {
            myStore.player.setPosX(move);
        }

        if (e == KeyCode.ESCAPE) {
            myStore.currentState = GameStatus.GAME_PAUSED;
            myStore.group.getChildren().add(myStore.pauseMenu);
            myStore.pauseMenu.showPauseMenu();
        }
    }

    private void onLost(KeyCode e) {
        // TODO: ON NOES WE LOST!
    }

    private void onWon(KeyCode e) {
        // TODO: WINNING YEAH!
    }

    private void onInactive(KeyCode e) {
        if (e == KeyCode.SPACE) {
            myStore.group.getChildren().remove(myStore.coin);
            myStore.group.getChildren().addAll(myStore.ball, myStore.player);
            myStore.currentState = GameStatus.GAME_RUNNING;
            myStore.ball.launch();
        }
    }
}
