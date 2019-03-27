package handlers;

import drivers.BattleshipGalactica;
import gui.ShipPlaceScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.Game;

public class BtnReplayHandler implements EventHandler<ActionEvent>{

    BattleshipGalactica session;
    
    public BtnReplayHandler(BattleshipGalactica session) {
    	this.session = session;
    }
    
    @Override
    public void handle(ActionEvent event){
    	
		session.setGame(new Game());
		ShipPlaceScene scene = new ShipPlaceScene(session);
		scene.setup();
        
        
    }
}
