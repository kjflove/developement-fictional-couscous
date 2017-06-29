package arkaniod.controller;

import arkaniod.models.GameStore;
import arkaniod.views.GameStatus;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 * Class description ...
 * Included in arkaniod.models
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 13. Mai 2017
 */
public class AnimationController {

    private GameStore myGameStore;
    private Timeline timeline;
    private KeyFrame kf;

    public AnimationController(GameStore myGameStore) {
        super();
        this.myGameStore = myGameStore;
        this.timeline = new Timeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.kf = new KeyFrame(Duration.millis(1000 / 60), this::handle);
        this.timeline.getKeyFrames().add(kf);
        this.timeline.play();
    }

    public void handle(ActionEvent event) {
        if (myGameStore.currentState == GameStatus.GAME_RUNNING) {
            myGameStore.ball.executeMoveLogic();
            myGameStore.player.movePlayerBar();
        } else if (myGameStore.currentState == GameStatus.GAME_INACTIVE) {
            myGameStore.coin.moveCoin();
        }
    }
}
