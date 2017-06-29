package application.controller;


import application.views.IPublicView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Class description ...
 * Included in application.controller
 *
 * @author Marvin Piekarek (s0556014)
 * @version 1.0
 * @since 21. Apr 2017
 */
public final class MainMenuController implements EventHandler<ActionEvent> {

    private IPublicView myView;

    private MainMenuController() {
        // Please don't use this with out any parameters
    }

    public MainMenuController(IPublicView view){
        myView = view;
    }

    /**
     * Invoked when a specific event of the type for which this handler is
     * registered happens.
     *
     * @param event the event which occurred
     */
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == myView.getListOfButtons().get("edit-button")){
            this.myView.getPrimaryStage().setScene(
                    IPublicView.allRegisteredViews.get("edit-view").getScene()
            );
        } else if(event.getSource() == myView.getListOfButtons().get("exit-button")){
            System.exit(0);
        }
    }

}

