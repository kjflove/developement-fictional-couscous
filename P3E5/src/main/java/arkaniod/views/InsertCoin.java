package arkaniod.views;

import arkaniod.models.GameStore;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

/**
 * Class description ...
 * Included in arkaniod.models
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 17. Mai 2017
 */
public class InsertCoin extends ImageView {

    private final double MAX_SCALE = 1;
    private final double MIN_SCALE = 0.95;
    private Scene myScene;
    private GameStore myStore;
    private Image coin;
    private double currentScale = 1;
    private boolean isBloating = false;

    public InsertCoin(Scene scene, GameStore myStore, InputStream in) {
        this.myScene = scene;
        this.myStore = myStore;
        this.coin = new Image(in);
        this.setImage(coin);
        showInsertCoinPicture();
    }

    private void showInsertCoinPicture() {
        if (myStore.currentState != GameStatus.GAME_RUNNING) {
            this.setY(myScene.getWidth() / 2 - coin.getWidth() / 2);
            this.setY(myScene.getHeight() / 2 - coin.getHeight() / 2);
        }
    }

    public void moveCoin() {
        if (isBloating) {
            if (currentScale >= MAX_SCALE) {
                isBloating = false;
            }
            this.currentScale += .001;
        } else {
            if (currentScale <= MIN_SCALE) {
                isBloating = true;
            }
            this.currentScale -= .001;
        }

        this.setFitHeight(this.coin.getHeight() * this.currentScale);
        this.setFitWidth(this.coin.getWidth() * this.currentScale);
        this.setX(myScene.getWidth() / 2 - this.getFitWidth() / 2);
        this.setY(myScene.getHeight() / 2 - this.getFitHeight() / 2);
    }

}
