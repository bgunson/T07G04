package handlers;

import drivers.BattleshipGalactica;
import gui.AttackScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnSwitchOrientationHandler implements EventHandler<ActionEvent>{

    BattleshipGalactica session;
    
    public BtnSwitchOrientationHandler(BattleshipGalactica session){
        this.session = session;
    }
    
    @Override
    public void handle(ActionEvent event){
        session.getGame().switchOrientation();
    }
}
