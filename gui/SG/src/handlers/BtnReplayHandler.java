package handlers;

import drivers.BattleshipGalactica;
import gui.ShipPlaceScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.Game;

/*
Handles the event when the replay button is quit.
 */
public class BtnReplayHandler implements EventHandler<ActionEvent>{

    // Current session.
    private BattleshipGalactica session;

    /**
     * Construct handler with the current driver.
     */
    public BtnReplayHandler(BattleshipGalactica session) {
    	this.session = session;
    }

    /**
     * Via the current session, a new game is initiated and application returns to ship place scene.
     */
    @Override
    public void handle(ActionEvent event){
    	
		session.setGame(new Game());
		ShipPlaceScene scene = new ShipPlaceScene(session);
		scene.setup();
        
        
    }
}
