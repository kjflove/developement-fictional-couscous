package application.views;

import application.controller.MainMenuController;
import application.model.FieldOfStudies;
import application.model.Gender;
import application.model.PersonStore;
import application.model.Student;
import application.utility.StudentFactory;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

/**
 * Class description ...
 * Included in application.views
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 29. Apr 2017
 */
public final class StudentMainMenu extends IPublicView {

    private Button editStudent = new Button();
    private Button endApplication = new Button();
    private Button refresh = new Button();
    private ListView<Student> listOfStudents;

    private ObservableList<Student> studentStore;

    private MainMenuController menuController;

    private GridPane pane;


    public StudentMainMenu(Scene myScene, Stage primStage, GridPane pane, ObservableList<Student> studentPersonStore) {
        super(myScene, "main-view", primStage);
        this.pane = pane;
        this.studentStore = studentPersonStore;
        InitializeComponents();
    }

    private void InitializeComponents(){

        pane.setPadding(new Insets(10,10,10, 10));
        pane.setVgap(8);
        pane.setHgap(10);

        listOfStudents = new ListView<>();
        listOfStudents.getItems().addAll(studentStore);


        // initialize inner view
        editStudent.setText("add new student");
        refresh.setText("refresh");
        endApplication.setText("exit application");
        editStudent.setStyle("-fx-focus-color: transparent;");

        GridPane.setConstraints(listOfStudents, 0, 0, 30, 5);
        GridPane.setConstraints(editStudent, 0 , 6, 5, 1);
        GridPane.setConstraints(refresh, 6,6, 5,1);
        GridPane.setConstraints(endApplication, 11,6, 5,1);

        pane.getChildren().addAll(editStudent, endApplication, listOfStudents, refresh);

        // adding all buttons to a dictionary with a unqiue id.
        listOfButtons.put("edit-button", editStudent);
        listOfButtons.put("exit-button", endApplication);

        // pass this list plus the view to the controller to change it if it is needed
        menuController = new MainMenuController(this);
        refresh.setOnAction(e -> {
            listOfStudents.getItems().clear();
            listOfStudents.getItems().addAll(studentStore);
        });

        editStudent.setOnAction(menuController);
        endApplication.setOnAction(menuController);
    }
}
