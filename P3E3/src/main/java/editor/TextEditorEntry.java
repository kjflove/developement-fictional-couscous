package editor;

import editor.model.TextState;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.io.IOException;
import java.util.Optional;
import java.util.function.Function;


/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 03. Mai 2017
 */
public class TextEditorEntry extends Application {

    final KeyCombination ctrlF = KeyCodeCombination.keyCombination("Ctrl+F");
    private boolean hasSearchPanel = false;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Texteditor ... 8000");

        BorderPane pane = new BorderPane();
        Scene mainScene = new Scene(pane, 600, 500);
        TextArea textField = new TextArea("Enter your text here ...");

        Function<KeyEvent, Void> k = event -> {
            if (ctrlF.match(event) && !hasSearchPanel) {
                try{
                    hasSearchPanel = true;
                    new SearchModule(textField);
                } catch (InterruptedException e){
                    // TODO: test that the exception get called after we were finished searching
                    hasSearchPanel = false;
                }
            }
            return null;
        };

        textField.setOnKeyPressed(k::apply);

        TextState textState = new TextState(primaryStage);
        textField.textProperty().bindBidirectional(textState.getObservableText());

        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");

        MenuItem newFile = new MenuItem("new file");
        newFile.setOnAction(e -> textState.getObservableText().setValue(""));
        MenuItem openFile = new MenuItem("open file");
        openFile.setOnAction(e -> {
            try {
                textState.loadFromFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        MenuItem saveFile = new MenuItem("save as ...");
        saveFile.setOnAction(e -> {
            try {
                textState.saveToFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        MenuItem search = new MenuItem("search and replace");
        search.setOnAction(e -> {
            if (!hasSearchPanel) {
                try{
                    hasSearchPanel = true;
                    new SearchModule(textField);
                } catch (InterruptedException ex){
                    // TODO: test that the exception get called after we were finished searching
                    hasSearchPanel = false;
                }
            }
        });
        menuEdit.getItems().add(search);

        MenuItem exit = new MenuItem("exit application");
        exit.setOnAction(e -> System.exit(0));

        menuFile.getItems().addAll(newFile, openFile, saveFile,new SeparatorMenuItem(), exit);
        menuBar.getMenus().addAll(menuFile, menuEdit);

        pane.setCenter(textField);
        pane.setTop(menuBar);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
