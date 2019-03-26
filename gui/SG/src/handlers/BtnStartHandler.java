package handlers;

import drivers.BattleshipGalatica;
import gui.SecondScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnStartHandler implements EventHandler<ActionEvent>{

    BattleshipGalatica session;
    
    public BtnStartHandler(BattleshipGalatica session){
        this.session = session;
    }
    
    @Override
    public void handle(ActionEvent event){
        
        // Create the second scene and set it up
        SecondScene scene = new SecondScene(session);
        scene.setup();
    }
}
