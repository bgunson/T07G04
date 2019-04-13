package handlers;

import drivers.BattleshipGalactica;
import gui.AttackScene;
//import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BtnPlaceShipHandler implements EventHandler<ActionEvent>{

    BattleshipGalactica session;
    int x;
    int y;
     /**
     * @param session retrieves the session
     * @param x retrieves the current x coordinate
     * @param y retrieves the current y coordinate
     */
    public BtnPlaceShipHandler(BattleshipGalactica session, int x, int y){
        this.session = session;
        this.x = x;
        this.y = y;
    }
    
    @Override
            /**
     *  Places ship using the given coorindates
     */
    public void handle(ActionEvent event){
        
        session.getGame().placeNextShip(x, y);
        //session.getGame().getPlayerOneShips().boardDisplay();
        if (session.getGame().allShipsPlaced() == true){
            AttackScene scene = new AttackScene(session);
            scene.setup();
        }
    }
}
