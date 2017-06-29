package editor;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class description ...
 * Included in editor
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 04. Mai 2017
 */
public class SearchModule {

    public static boolean isActive = false;

    private TextArea field;
    private Stage stage;
    private int lastPoint = -1;
    private TextField text, replace;
    private Label label, replaceLabel;
    private CheckBox caseSensitve;
    private List<Integer> allOccurrences = new ArrayList<>();

    public SearchModule(TextArea textField) throws InterruptedException {
        this.field = textField;
        stage = new Stage();
        stage.setTitle("find occurrences ...");
        BorderPane k = new BorderPane();

        k.setBottom(addButtonBox());
        k.setTop(addTitleBox());
        k.setCenter(addSearchTile());

        stage.setScene(new Scene(k, 550, 115));
        stage.resizableProperty().set(false);
        stage.showAndWait();
        throw new InterruptedException();

    }

    private HBox addButtonBox() throws InterruptedException {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 12, 5, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonPrev = new Button("> previous");
        buttonPrev.setOnAction(e -> searchPrevious());

        Button buttonNext = new Button("> next");
        buttonNext.setOnAction(e -> searchNext());

        Button buttonReplace = new Button("> replace");
        //buttonNext.setPrefSize(50, 15);
        buttonReplace.setOnAction(e -> replace());

        Button buttonSkip = new Button("> skip");
        //buttonNext.setPrefSize(50, 15);
        buttonSkip.setOnAction(e -> skip());

        caseSensitve = new CheckBox("case sensitivity");
        caseSensitve.setStyle("-fx-text-fill: white;");
        caseSensitve.selectedProperty().addListener((e) -> {
            searchForAllOccurrences();
            label.setText("Enter your search string: (" + allOccurrences.size() + " found)");
        });

        Button buttonClose = new Button("close");
        //buttonNext.setPrefSize(25, 15);
        buttonClose.setOnAction((e) -> stage.close());

        hbox.getChildren().addAll(buttonPrev, buttonNext, buttonReplace, buttonSkip, buttonClose, caseSensitve );

        return hbox;
    }

    private HBox addSearchTile() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 12, 5, 12));
        hbox.setSpacing(10);

        text = new TextField("");
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            searchForAllOccurrences();
            label.setText("Enter your search string: (" + allOccurrences.size() + " found)");
        });
        text.setPrefSize(250, 15);

        replace = new TextField("");
        replace.setPrefSize(250, 15);

        hbox.getChildren().addAll(text, replace);

        return hbox;
    }

    private HBox addTitleBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(5, 12, 5, 12));
        hbox.setSpacing(10);

        label = new Label("Enter your search string:");
        label.setPrefSize(250, 15);

        replaceLabel = new Label("Replace string:");
        replaceLabel.setPrefSize(250, 15);
        hbox.getChildren().addAll(label, replaceLabel);

        return hbox;
    }

    private boolean searchNext(){
        if(allOccurrences.size() > 0 && allOccurrences.size() - 1 > lastPoint){
            lastPoint++;
            int nextRange = allOccurrences.get(lastPoint);
            field.selectRange(nextRange, text.getText().length() + nextRange);
            return true;
        }

        return false;
    }

    private boolean searchPrevious(){
        if(allOccurrences.size() > 0 && lastPoint > 0){
            lastPoint--;
            int nextRange = allOccurrences.get(lastPoint);
            field.selectRange(nextRange, text.getText().length() + nextRange);
            return true;
        }

        return false;
    }

    private boolean replace(){
        if (allOccurrences.size() > 0 && allOccurrences.size() - 1 > lastPoint) {
            field.replaceSelection(replace.getText());
            searchForAllOccurrences();
            return true;
        }

        return false;
    }

    private boolean skip(){
        return searchNext();
    }

    private void searchForAllOccurrences(){
        List<Integer> occurrences = new ArrayList<>();

        Matcher m = Pattern
                .compile("(?=(" + Pattern.quote(text.getText()) + "))",
                        caseSensitve.isSelected() ? 0 : Pattern.CASE_INSENSITIVE)
                .matcher(field.getText());

        while (m.find()) { occurrences.add(m.start()); }

        if(occurrences.size() > 0) {
            field.selectRange(occurrences.get(0), occurrences.get(0) + text.getText().length());
        } else {
            field.selectRange(0, 0);
        }

        lastPoint = -1;
        allOccurrences = occurrences;
    }
}
