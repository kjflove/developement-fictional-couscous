package application.views;

import application.controller.EditStudentController;
import application.controller.MainMenuController;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import application.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

/**
 * Class description ...
 * Included in application.views
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 29. Apr 2017
 */
public final class StudentEditView extends IPublicView {

    private Button saveButton = new Button();
    private Button cancelButton = new Button();
    private EditStudentController editController;
    private MainMenuController menuController;

    private ObservableList<Student> studentStore;

    private GridPane pane;

    private Label surnameL, nameL, enmL, DoBL, FoSL, SemL, CourseL;
    private TextField surnameT, nameT, enmT;
    private DatePicker DoBD;
    private ComboBox<FieldOfStudies> FoSC;
    private ComboBox<Courses> CourseC;
    private ComboBox<Integer> SemC;

    public StudentEditView(Scene myScene, Stage primStage, GridPane pane, ObservableList<Student> studentPersonStore) {
        super(myScene, "edit-view", primStage);
        this.pane = pane;
        this.studentStore = studentPersonStore;
        InitializeComponents();
    }

    private void InitializeComponents(){

        pane.setPadding(new Insets(10,10,10, 10));
        pane.setVgap(8);
        pane.setHgap(10);

        // initialize inner view
        saveButton.setText("Save student");
        saveButton.setStyle("-fx-focus-color: transparent;");
        cancelButton.setText("cancel");

        // adding all buttons to a dictionary with a unqiue id.
        this.listOfButtons.put("save-button", saveButton);
        this.listOfButtons.put("cancel-button", cancelButton);

        surnameL = new Label("surname: ");
        surnameT = new TextField("");
        GridPane.setConstraints(surnameL, 0, 0);
        GridPane.setConstraints(surnameT, 1,0);

        nameL = new Label("name: ");
        nameT = new TextField("");
        GridPane.setConstraints(nameL, 0, 1);
        GridPane.setConstraints(nameT, 1,1);

        enmL = new Label("enrolment number: ");
        enmT = new TextField("");
        GridPane.setConstraints(enmL, 0, 2);
        GridPane.setConstraints(enmT, 1,2);

        DoBL = new Label("date of birth: ");
        DoBD = new DatePicker();
        GridPane.setConstraints(DoBL, 0, 3);
        GridPane.setConstraints(DoBD, 1,3);

        FoSL = new Label("field of study: ");
        ObservableList<FieldOfStudies> options =
                FXCollections.observableArrayList(FieldOfStudies.values());
        FoSC = new ComboBox<FieldOfStudies>(options);
        FoSC.tooltipProperty().setValue(new Tooltip("Bitte wähle dein Studiengang aus."));

        GridPane.setConstraints(FoSL, 0, 4);
        GridPane.setConstraints(FoSC, 1,4);

        Integer[] semester = {1,2,3,4,5,6};
        SemL = new Label("semester: ");
        ObservableList<Integer> optionsSemester =
                FXCollections.observableArrayList(semester);
        SemC = new ComboBox<>(optionsSemester);
        SemC.tooltipProperty().setValue(new Tooltip("Bitte wähle dein Semester aus."));

        GridPane.setConstraints(SemL, 0, 5);
        GridPane.setConstraints(SemC, 1, 5);

        CourseL = new Label("courses: ");
        MenuButton choices = new MenuButton("Choises");
        final List<CheckMenuItem> items = new ArrayList<>(Arrays.asList(
                new CheckMenuItem(Courses.ENGLISH.name()),
                new CheckMenuItem(Courses.MATHS.name()),
                new CheckMenuItem(Courses.GERMAN.name()),
                new CheckMenuItem(Courses.NETWORKING.name())
        ));
        // CourseC = new ComboBox<Courses>(optionsCourse);
        // CourseC.tooltipProperty().setValue(new Tooltip("Bitte wählen sie Ihre Kurse aus."));
        choices.getItems().addAll(items);

        GridPane.setConstraints(CourseL, 0, 6);
        GridPane.setConstraints(choices, 1,6);

        GridPane.setConstraints(cancelButton, 0, 7, 2, 1);
        GridPane.setConstraints(saveButton, 1, 7, 2, 1);
        pane.getChildren().addAll(saveButton, cancelButton, surnameL, surnameT, nameL, nameT, enmL, enmT, DoBL, DoBD, FoSC, FoSL, SemL, SemC, choices, CourseL);

        // pass this list plus the view to the controller to change it if it is needed.
        editController = new EditStudentController(this, studentStore);
        menuController = new MainMenuController(this);
        saveButton.setOnAction(e ->
            editController.handle(e, DoBD, FoSC, null, surnameT, nameT, enmT, SemC, choices.getItems())
        );
        cancelButton.setOnAction(editController);
    }
}
