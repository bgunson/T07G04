package handlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
Handles the event when the user clicks a quit button.
 */
public class BtnQuitHandler implements EventHandler<ActionEvent>{

    /**
     * Quits the appliction upon a click.
     */
    @Override
    public void handle(ActionEvent event){
        Platform.exit();
    }
}
