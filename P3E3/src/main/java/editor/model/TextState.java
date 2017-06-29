package editor.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Class description ...
 * Included in editor.model
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 03. Mai 2017
 */
public class TextState {

    private StringProperty textArea;
    private Stage primStage;

    public void saveToFile() throws IOException {
        File file = new FileChooser().showSaveDialog(primStage);
        if (!checkIfFileValid(file)) {
            return;
        }

        try (
                Writer out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file.getAbsolutePath()), "UTF-8"))
        ) {
            out.write(this.textArea.getValue());
        }

    }

    public void loadFromFile() throws IOException {
        File file = new FileChooser().showOpenDialog(primStage);
        if(!checkIfFileValid(file)) return;
        String fileStr = "";

        try {

            InputStream is = new FileInputStream(file.getAbsolutePath());
            String UTF8 = "utf8";
            int BUFFER_SIZE = 8192;

            BufferedReader br = new BufferedReader(new InputStreamReader(is,
                    UTF8), BUFFER_SIZE);
            String str;
            while ((str = br.readLine()) != null) {
                fileStr += str + "\n";
            }

            this.textArea.setValue(fileStr);
        } catch (Exception e) {

        }

    }

    public boolean checkIfFileValid(File file){
        if (file == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText(null);
            alert.setContentText("You file hasn't been saved. Either the path wasn't correct or you've canceled the operation.");
            alert.show();
            return false;
        }
        return true;
    }


    public TextState(String initText, Stage prim) {
        this.textArea = new SimpleStringProperty(initText);
        this.primStage = prim;
    }

    public TextState(Stage prim) {
        this.textArea = new SimpleStringProperty("Edit your text in here.");
        this.primStage = prim;
    }

    public String getTextArea() {
        return textArea.getValue();
    }

    public StringProperty getObservableText() {
        return textArea;
    }

    public ObservableValue<String> textAreaProperty() {
        return textArea;
    }

}
