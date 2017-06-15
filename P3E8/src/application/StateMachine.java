package application;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;


/**
 * Class description ...
 * Included in application
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 14. Jun 2017
 */
public class StateMachine implements Runnable {

    private TrafficLight currentStatus = TrafficLight.RED;
    private TrafficLight activeStatus = TrafficLight.BLINKING;

    private Ellipse red;
    private Ellipse yellow;
    private Ellipse green;

    private boolean isYellowColor = true;

    private Timeline blink;

    StateMachine(Ellipse red, Ellipse yellow, Ellipse green) {
        this.red = red;
        this.red.setFill(Color.RED);
        this.yellow = yellow;
        this.green = green;
        this.blink = new Timeline(
                new KeyFrame(new Duration(1000), "blinking", (e) -> {
                    if (isYellowColor) {
                        this.yellow.setFill(Color.BLACK);
                        this.isYellowColor = !isYellowColor;
                    } else {
                        this.yellow.setFill(Color.YELLOW);
                        this.isYellowColor = !isYellowColor;
                    }
                })
        );
        this.blink.setCycleCount(Animation.INDEFINITE);
    }

    synchronized TrafficLight getCurrentStatus() {
        return currentStatus;
    }

    synchronized void setCurrentStatus(TrafficLight currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public void run() {
        while (true) {
            switch (this.getCurrentStatus()) {
                case GREEN:
                    if (activeStatus != TrafficLight.GREEN) {
                        clearColors();
                        setGreen();
                        activeStatus = TrafficLight.GREEN;
                    }
                    break;
                case YELLOW:
                    if (activeStatus != TrafficLight.YELLOW) {
                        clearColors();
                        setYellow();
                        activeStatus = TrafficLight.YELLOW;
                    }
                    break;
                case YELLOW_RED:
                    if (activeStatus != TrafficLight.YELLOW_RED) {
                        clearColors();
                        setYellow();
                        setRed();
                        activeStatus = TrafficLight.YELLOW_RED;
                    }
                    break;
                case RED:
                    if (activeStatus != TrafficLight.RED) {
                        clearColors();
                        setRed();
                        activeStatus = TrafficLight.RED;
                    }
                    break;
                case BLINKING:
                    if (activeStatus != TrafficLight.BLINKING) {
                        clearColors();
                        blink();
                        activeStatus = TrafficLight.BLINKING;
                    }
                    break;
            }

            if (this.getCurrentStatus() != TrafficLight.BLINKING)
                this.blink.stop();

            this.setCurrentStatus(this.getCurrentStatus().eval(this));

        }
    }

    private void clearColors() {
        this.red.fillProperty().setValue(Color.BLACK);
        this.green.fillProperty().setValue(Color.BLACK);
        this.yellow.fillProperty().setValue(Color.BLACK);
    }

    private void setRed() {
        this.red.fillProperty().setValue(Color.RED);
    }

    private void setYellow() {
        this.yellow.fillProperty().setValue(Color.YELLOW);
    }

    private void setGreen() {
        this.green.fillProperty().setValue(Color.GREEN);
    }

    private void blink() {
        blink.play();
    }
}
