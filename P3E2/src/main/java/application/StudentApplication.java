package application;

import application.model.FieldOfStudies;
import application.model.Gender;
import application.model.PersonStore;
import application.model.Student;
import application.utility.EnumFactory;
import application.utility.StudentFactory;
import application.views.IPublicView;
import application.views.StudentEditView;
import application.views.StudentMainMenu;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import sun.net.util.IPAddressUtil;

import javax.xml.soap.Text;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


/**
 * Class description ...
 * Included in PACKAGE_NAME
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 24. Apr 2017
 */
public class StudentApplication
        extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
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

        primaryStage.setTitle("Student management system");

        PersonStore<Student> studentStore = new PersonStore<>();
        studentStore.addAll(StudentFactory.listOfStudents);
        ObservableList<Student> students = FXCollections.observableArrayList(studentStore);

        GridPane gp = new GridPane();
        Scene sEdit = new Scene(gp, 350, 325);
        IPublicView edit = new StudentEditView(sEdit, primaryStage, gp, students);

        GridPane gp2 = new GridPane();
        Scene mainScene = new Scene(gp2, 500, 475);
        IPublicView main = new StudentMainMenu(mainScene, primaryStage, gp2, students);

        primaryStage.setScene(main.getScene());
        primaryStage.show();

    }


}
