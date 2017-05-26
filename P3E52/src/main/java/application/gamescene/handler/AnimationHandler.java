package application.gamescene.handler;

import application.Bootstrap;
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
    private Bootstrap bt;

    public AnimationHandler(Bootstrap bt){
        this.bt = bt;
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.ourFrame = new KeyFrame(new Duration(1000/60), bt::animate);
        this.timeline.getKeyFrames().add(ourFrame);
        this.timeline.play();
    }

}
