package application.controller;

import application.model.*;
import application.views.IPublicView;
import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.tools.javah.Gen;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.util.List;

/**
 * Class description ...
 * Included in application.controller
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 21. Apr 2017
 */
public final class EditStudentController implements EventHandler<ActionEvent> {

    private IPublicView myView;
    private ObservableList<Student> studentStore;

    private EditStudentController() {
        // Please don't use this with out any parameters
    }

    public EditStudentController(IPublicView view, ObservableList<Student> studentStore){
        myView = view; this.studentStore = studentStore;
    }

    public void handle(ActionEvent event, DatePicker dp, ComboBox<FieldOfStudies> fos, ComboBox<Courses> c, TextField surname, TextField name, TextField enm, ComboBox<Integer> SemC, ObservableList<MenuItem> courses) {

        if(event.getSource() == myView.getListOfButtons().get("save-button")) {

            try{
                int k = Integer.parseInt(enm.getText());
                Student createdStudent = new Student(surname.getText(), name.getText(), dp.getValue(), Gender.OTHERS, k, SemC.getValue(), fos.getValue(), null);
                studentStore.add(createdStudent);
                System.out.println("Student has been added.");
            } catch(InvalidArgumentException e){
                System.out.println("Caught you for typing wrong things.");
            } catch(Exception e){
                System.out.println("ENM not a Integer");
            }

            Scene main = IPublicView.allRegisteredViews.get("main-view").getScene();
            this.myView.getPrimaryStage().setScene(main);

        }
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == myView.getListOfButtons().get("cancel-button")) {
            this.myView.getPrimaryStage().setScene(
                    IPublicView.allRegisteredViews.get("main-view").getScene()
            );
        }
    }
}
