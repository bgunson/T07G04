package handlers;

import drivers.BattleshipGalactica;
import gui.AttackScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/*
Handles the mouse events for placing ships.
 */
public class BtnPlaceShipHandler implements EventHandler<ActionEvent>{

    // Current session, and click position (x,y)
    BattleshipGalactica session;
    int x;
    int y;

    /**
     * Construct handler object with the driver, and click position.
     */
    public BtnPlaceShipHandler(BattleshipGalactica session, int x, int y){
        this.session = session;
        this.x = x;
        this.y = y;
    }

    /**
     * Override the handle method; places ship, if all have been placed the next scene is initiated.
     */
    @Override
    public void handle(ActionEvent event){
        
        session.getGame().placeNextShip(x, y);
        //session.getGame().getPlayerOneShips().boardDisplay();
        if (session.getGame().allShipsPlaced() == true){
            AttackScene scene = new AttackScene(session);
            scene.setup();
        }
    }
}
