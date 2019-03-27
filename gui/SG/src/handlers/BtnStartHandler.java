package handlers;

import drivers.BattleshipGalactica;
import gui.ShipPlaceScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnStartHandler implements EventHandler<ActionEvent>{

    BattleshipGalactica session;
    
    public BtnStartHandler(BattleshipGalactica session){
        this.session = session;
    }
    
    @Override
    public void handle(ActionEvent event){
        
        // Create the second scene and set it up
        ShipPlaceScene scene = new ShipPlaceScene(session);
        scene.setup();
        
    }
}
