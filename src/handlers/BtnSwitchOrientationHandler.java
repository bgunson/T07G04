package handlers;

import drivers.BattleshipGalatica;
import gui.ThirdScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnSwitchOrientationHandler implements EventHandler<ActionEvent>{

    BattleshipGalatica session;
    
    public BtnSwitchOrientationHandler(BattleshipGalatica session){
        this.session = session;
    }
    
    @Override
    public void handle(ActionEvent event){
        session.getGame().switchOrientation();
    }
}
