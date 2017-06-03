package application.menuscene;

import application.Bootstrap;
import application.GameType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import jdk.internal.dynalink.support.BottomGuardingDynamicLinker;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Class description ...
 * Included in application.menuscene
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 27. Mai 2017
 */
public class MainMenu implements IMenu {

    private List<Node> children = new LinkedList<>();
    private Label play;
    private Label exit;
    private VBox vbox;

    public MainMenu(Bootstrap bt){
        this.play = new Label("Start playing");
        this.play.setTextFill(Color.WHITE);
        this.play.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        this.play.setTextAlignment(TextAlignment.CENTER);
        this.play.setOnMouseEntered((event -> this.play.setTextFill(Color.AQUA)));
        this.play.setOnMouseExited((event -> this.play.setTextFill(Color.WHITE)));
        this.play.setOnMouseClicked((event -> bt.status.set(GameType.RUNNING)));

        this.exit = new Label("Exit game ...");
        this.exit.setTextFill(Color.WHITE);
        this.exit.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        this.play.setTextAlignment(TextAlignment.CENTER);
        this.exit.setOnMouseEntered((event -> this.exit.setTextFill(Color.AQUA)));
        this.exit.setOnMouseExited((event -> this.exit.setTextFill(Color.WHITE)));
        this.exit.setOnMouseClicked((event -> System.exit(0)));
        // this.children.add(this.exit);

        this.vbox = new VBox(10);
        this.vbox.setAlignment(Pos.CENTER);
        this.vbox.getChildren().addAll( this.play, this.exit);
        this.children.add(vbox);
    }

    @Override
    public Collection<Node> getAllChildren() {
        return this.children;
    }

    @Override
    public String getName() {
        return null;
    }
}
