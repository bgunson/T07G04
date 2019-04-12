package handlers;

import Audio.AudioController;
import drivers.BattleshipGalactica;
import gui.FirstScene;
import gui.ShipPlaceScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.Game;

/*
Handles events when the start button is clicked.
 */
public class BtnStartHandler implements EventHandler<ActionEvent>{

    // Current session.
    BattleshipGalactica session;

    /**
     * Constructs a hanlder with the current driver.
     */
    public BtnStartHandler(BattleshipGalactica session){
        this.session = session;
    }

    /**
     * When clicked; music is started and application goes to the ship place scene.
     */
    @Override
    public void handle(ActionEvent event){
    	Game startMusic = new Game();
    	startMusic.startMusic();
        // Create the second scene and set it up
        ShipPlaceScene scene = new ShipPlaceScene(session);
        scene.setup();
        
    }
}
