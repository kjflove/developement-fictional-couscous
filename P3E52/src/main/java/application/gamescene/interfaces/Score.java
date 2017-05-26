package application.gamescene.interfaces;

import javafx.beans.property.SimpleLongProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Class description ...
 * Included in application.gamescene.interfaces
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 26. Mai 2017
 */
public class Score extends Pane {

    private SimpleLongProperty scoreCount = new SimpleLongProperty(0);
    private Label label;

    public void resetScore() {
        this.scoreCount.set(0);
    }

    public void addScoreCount(int add){
        this.scoreCount.set(this.scoreCount.getValue() + add);
    }

    public long getScoreCount() {
        return scoreCount.getValue();
    }

    public Score() {
        this.label = new Label("Score: " + scoreCount.getValue() );
        this.label.setTextFill(Color.GREEN);
        this.label.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        this.getChildren().add(this.label);

        this.scoreCount.addListener(((observable, oldValue, newValue) ->
            this.label.setText("Score: " + this.scoreCount.getValue())
        ));
    }
}
