package application.gamescene.handler;

import application.gamescene.GameScene;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 23. Mai 2017
 */
public class AnimationHandler {

    private KeyFrame ourFrame;
    private Timeline timeline = new Timeline();

    public AnimationHandler(GameScene gameScene){
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.ourFrame = new KeyFrame(new Duration(1000/60), gameScene::animate);
        this.timeline.getKeyFrames().add(ourFrame);
        this.timeline.play();
    }

    public void stop() {
        this.timeline.stop();
    }

}
