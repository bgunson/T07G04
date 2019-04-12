package handlers;

import drivers.BattleshipGalactica;
import gui.AttackScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
Handles events for the orientation button.
 */
public class BtnSwitchOrientationHandler implements EventHandler<ActionEvent>{

    // The current session.
    BattleshipGalactica session;

    /**
     * Constructs a handler with th ecurrent driver.
     */
    public BtnSwitchOrientationHandler(BattleshipGalactica session){
        this.session = session;
    }

    /**
     * Switches the current placement orientation when clicked.
     */
    @Override
    public void handle(ActionEvent event){
        session.getGame().switchOrientation();
    }
}
