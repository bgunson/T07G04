package handlers;

import Audio.AudioController;
import drivers.BattleshipGalactica;
import gui.FirstScene;
import gui.ShipPlaceScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import logic.Game;

public class BtnStartHandler implements EventHandler<ActionEvent>{

    BattleshipGalactica session;
    
    public BtnStartHandler(BattleshipGalactica session){
        this.session = session;
    }
    
    @Override
     /**
     *  Starts the game after being clicked
     */
    public void handle(ActionEvent event){
    	Game startMusic = new Game();
    	startMusic.startMusic();
        // Create the second scene and set it up
        ShipPlaceScene scene = new ShipPlaceScene(session);
        scene.setup();
        
    }
}
