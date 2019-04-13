package handlers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnQuitHandler implements EventHandler<ActionEvent>{

    @Override
    //Quits the game
    public void handle(ActionEvent event){
        Platform.exit();
    }
}
