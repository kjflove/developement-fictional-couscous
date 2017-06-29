package arkaniod.views;

import arkaniod.models.GameStore;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Class description ...
 * Included in arkaniod.models
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 18. Mai 2017
 */
public class PauseMenu extends Pane {

    private Label pauseText;
    private GameStore myGameStore;

    public PauseMenu(GameStore myGameStore) {
        this.myGameStore = myGameStore;

        pauseText = new Label("Game Pause");
        pauseText.setTextFill(Color.WHITE);
        pauseText.setFont(new Font("Arial", 30));

        this.setWidth(200);
        this.setHeight(200);
    }

    public void showPauseMenu() {
        this.getChildren().add(pauseText);
    }

    public void hidePauseMenu() {
        this.getChildren().remove(pauseText);
    }

}
