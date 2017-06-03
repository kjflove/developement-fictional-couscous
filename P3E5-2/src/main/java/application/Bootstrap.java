package application;

import application.gamescene.GameScene;
import application.menuscene.MenuScene;
import application.statusscene.StatusScene;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 23. Mai 2017
 */
public class Bootstrap {
    // all scenes
    private GameScene gameScene;
    private MenuScene menuScene;
    private StatusScene statusScene;

    // JAVAFX things
    private Stage stage;

    public SimpleObjectProperty<GameType> status = new SimpleObjectProperty<>(GameType.INACTIVE);

    public Bootstrap(Stage primary) {
        this.stage = primary;

        this.gameScene = new GameScene(new Pane(), 600, 600, this);
        this.menuScene = new MenuScene(new StackPane(), 600, 600, this);
        // sthis.statusScene = new StatusScene(new StackPane(), 600, 600, this);
        this.status.addListener(((observable, oldValue, newValue) -> {
            // we need to change scenes based on gameScene status
            switch (newValue){
                case RUNNING:
                    this.gameScene.restart();
                    switchScene(this.gameScene);
                    break;
                case WIN:
                case LOSE:
                    //switchScene();
                    break;
                case INACTIVE:
                    switchScene(this.menuScene);
                    break;
                case PAUSE:
                    break;
            }
        }));

        switchScene(this.menuScene);
    }

    private void switchScene(Scene switchable){
        this.stage.setScene(switchable);
    }

    /*private static synchronized void playSound(final String url) {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream("/path/to/sounds/" + url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }*/
}
