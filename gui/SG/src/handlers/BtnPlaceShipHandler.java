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
    
    public BtnPlaceShipHandler(BattleshipGalactica session, int x, int y){
        this.session = session;
        this.x = x;
        this.y = y;
    }
    
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
