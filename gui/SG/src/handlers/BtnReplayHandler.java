package handlers;

import drivers.BattleshipGalactica;
import gui.ShipPlaceScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.Game;

public class BtnReplayHandler implements EventHandler<ActionEvent>{

    private BattleshipGalactica session;
    
    public BtnReplayHandler(BattleshipGalactica session) {
    	this.session = session;
    }
    
    @Override
	//Starts a new game after the current game is completed
    public void handle(ActionEvent event){
    	
		session.setGame(new Game());
		ShipPlaceScene scene = new ShipPlaceScene(session);
		scene.setup();
        
        
    }
}
